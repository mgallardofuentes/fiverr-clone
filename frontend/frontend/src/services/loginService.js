import axios from 'axios';

export const login = (username, password) => {
	return axios.post('https://proyectofiverrequipo3.herokuapp.com/api/login', {
		username,
		password
	});
}

export const register = (username, email, password) => {
	return axios.post('https://proyectofiverrequipo3.herokuapp.com/api/register', {
		username,
		email,
		password
	});
}