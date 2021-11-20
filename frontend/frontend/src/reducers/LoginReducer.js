export const LOGIN = 'LOGIN';
export const REGISTER = 'REGISTER';
export const ERROR = 'ERROR';
export const SUCCESS = 'SUCCESS';
export const RESET_ERRORS = 'RESET_ERRORS';
export const TOKEN = 'TOKEN';

const loginData = localStorage.getItem("login_data") ? JSON.parse(localStorage.getItem("login_data")) : "";

export const INITIAL_STATE = {
	mail: loginData !== "" ? loginData.mail : "",
	password: '',
	error: '',
	isLoading: false,
	isLogged: loginData !== "" ? true : false,
	token: loginData !== "" ? loginData.token : ''
}

export const LoginReducer = (state, action) => {
	switch(action.type) {
		case LOGIN:
			return {
				...state,
				error: '',
				isLoading: true,
				isLogged: false,
			}
		case REGISTER:
			return {
				...state,
				error: '',
				isLoading: true,
				isLogged: false
			}
		case SUCCESS:
			return {
				...state,
				error: '',
				isLoading: false,
				isLogged: true
			}
		case ERROR:
			return {
				...state,
				error: action.payload.error,
				isLoading: false,
				isLogged: false
			}
		case RESET_ERRORS: 
			return {
				...state,
				error: ''
			}
		case TOKEN:
			return {
				...state,
				token: action.payload.token
			}
		default:
			return state;
	}
}