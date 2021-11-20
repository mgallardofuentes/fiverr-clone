import './App.css';
import './custom.scss';
import { Routes, Route, Navigate } from 'react-router-dom';
import OfferDetail from './components/OfferDetail';
import Home from './components/Home';
import React, { useState, useReducer } from 'react';
import Category from './components/Category';
import Login from './components/Login';
import Register from './components/Register';
import { ERROR, INITIAL_STATE, LOGIN, LoginReducer, REGISTER, SUCCESS, RESET_ERRORS, TOKEN } from "./reducers/LoginReducer";
import { login, register } from './services/loginService';

export const appContext = React.createContext([]);

function App() {
	const [ searchTerm, setSearchTerm ] = useState('');
	const [ state, dispatch ] = useReducer(LoginReducer, INITIAL_STATE);
	const { isLogged } = state;

	const tryLogin = (e, email, password) => {
		e.preventDefault();
		dispatch({type: RESET_ERRORS});
		if(email === '' || password === '') {
			dispatch({type: ERROR, payload: {error: 'Los campos correo electrónico y/o contraseña no pueden estar vacíos'}});
		} else {
			dispatch({type: LOGIN});
			login(email, password)
			.then(response => {
				if(response.status === 200 && response.data.token) {
					const token = response.data.token;
					localStorage.setItem("login_data", JSON.stringify({email, token: token}));
					dispatch({type: TOKEN, payload: {token: token}})
					dispatch({type: SUCCESS});
					<Navigate to="/" />
				} else {
					dispatch({type: ERROR, payload: {error: 'Error al iniciar sesión. Inténtalo de nuevo o más tarde.'}});
				}
			}).catch(error => dispatch({type: ERROR, payload: {error: 'Error al iniciar sesión: ' + error}}));
		}
	}

	const tryRegister = (e, username, email, password, rpassword) => {
		e.preventDefault();
		dispatch({type: RESET_ERRORS});
		if(username === '' || email === '' || password === '' || rpassword === '') {
			dispatch({type: ERROR, payload: {error: 'Por favor, completa todos los campos para finalizar el registro'}});
		} else if(password !== rpassword) {
			dispatch({type: ERROR, payload: {error: 'Las contraseñas introducidas no coinciden'}});
		} else {
			dispatch({type: REGISTER});
			register(username, email, password)
			.then(response => {
				if(response.status === 200) {
					const token = response.data.token;
					localStorage.setItem("login_data", JSON.stringify({email, token: token}));
					dispatch({type: TOKEN, payload: {token: token}})
					dispatch({type: SUCCESS});
					<Navigate to="/" />
				} else {
					dispatch({type: ERROR, payload: {error: 'Error al registrarse. Inténtalo de nuevo o más tarde.'}});
				}
			}).catch(error => dispatch({type: ERROR, payload: {error: 'Error al registrarse: ' + error}}));
		}
	}

	return (
		<appContext.Provider value={state}>
			<div className="App">
				<Routes>
					<Route path="/" element={!isLogged ? <Navigate to="/login" /> : <Home setSearchTerm={setSearchTerm} searchTerm={searchTerm}/>} />
					<Route path="/categorias/:currentCategory" element={!isLogged ? <Navigate to="/login" /> : <Category setSearchTerm={setSearchTerm} searchTerm={searchTerm} />} />
					<Route path="/categorias/:currentCategory/ofertas/:id" element={!isLogged ? <Navigate to="/login" /> : <OfferDetail setSearchTerm={setSearchTerm}/>} />
					<Route path="/login" element={isLogged ? <Navigate to="/" /> : <Login tryLogin={tryLogin}/>}/>
					<Route path="/register" element={isLogged ? <Navigate to="/" /> : <Register tryRegister={tryRegister} />} />
				</Routes>
			</div>
		</appContext.Provider>
	);
}

export default App;
