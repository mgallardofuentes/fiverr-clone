import { useContext, useState } from 'react';
import { Form, Button, Container, Alert } from 'react-bootstrap';
import { Navigate, useNavigate } from 'react-router-dom';
import { appContext } from '../App';
import NavbarComp from './navbar/NavbarComp';

const Login = ({ tryLogin }) => {
	const [ email, setEmail ] = useState('');
	const [ password, setPassword ] = useState('');
	const { isLoading, isLogged, error } = useContext(appContext);
	const navigate = useNavigate();

	const goRegister = (e) => {
		e.preventDefault();
		navigate('/register');
	};

	return (
		<div style={{ margin: '0' }}>
			<NavbarComp setSearchTerm="" offers="" />
			<div className="background" />
			<Container className="home-wrapper">
				<Container fluid className="log-div">
					<h1 style={{ color: 'white', fontSize: '50px' }}>Bienvenido!</h1>
					<h2 style={{ color: 'white' }}>Inicia sesión</h2>
					<div className="loginBg mt-6 m-4" style={{ textAlign: 'left' }}>
						¿Aún no te has registrado?{' '}
						<a style={{ textDecoration: 'none' }} href="#" onClick={goRegister}>
							Crear cuenta
						</a>
					</div>
					<Form className="loginBg p-4 m-4" onSubmit={(e) => tryLogin(e, email, password)}>
						{error && <Alert variant={'danger'}>{error}</Alert>}
						<Form.Group style={{ textAlign: 'left' }} className="mt-4">
							<Form.Label>Nombre de usuario</Form.Label>
							<Form.Control
								type="text"
								required
								placeholder="Usuario"
								value={email}
								onChange={(e) => setEmail(e.currentTarget.value)}
							/>
						</Form.Group>

						<Form.Group style={{ textAlign: 'left' }} className="mt-4">
							<Form.Label>Contraseña</Form.Label>
							<Form.Control
								type="password"
								required
								placeholder="Contraseña"
								value={password}
								onChange={(e) => setPassword(e.currentTarget.value)}
							/>
						</Form.Group>

						<Button
							style={{ width: '100%' }}
							className="mt-4 mb-2"
							variant="primary"
							type="submit"
							disabled={isLoading}
						>
							{isLoading ? 'Iniciando sesión...' : 'Iniciar sesión'}
						</Button>
					</Form>
				</Container>
			</Container>
		</div>
	);
};

export default Login;
