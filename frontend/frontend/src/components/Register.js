import { Form, Button, Container, Row, Col, Alert } from 'react-bootstrap';
import { useContext, useState } from 'react';
import { Navigate, useNavigate } from 'react-router-dom';
import { appContext } from '../App';
import NavbarComp from './navbar/NavbarComp';

const Register = ({ tryRegister }) => {
	const [ email, setEmail ] = useState('');
	const [ username, setUsername ] = useState('');
	const [ password, setPassword ] = useState('');
	const [ rpassword, setRPassword ] = useState('');
	const { isLoading, isLogged, error } = useContext(appContext);
	const navigate = useNavigate();

	const goLogin = (e) => {
		e.preventDefault();
		navigate('/login');
	};

	return (
		<div>
			<div className="background" />
			<NavbarComp setSearchTerm="" offers="" register={true} />
			<Container className="home-wrapper">
				<Container fluid className="log-div">
					<h1 style={{ color: 'white', fontSize: '50px' }}>Bienvenido!</h1>
					<h2 style={{ color: 'white' }}>Regístrate</h2>
					<div className="loginBg mt-6 m-4" style={{ textAlign: 'left' }}>
						¿Ya tienes una cuenta?{' '}
						<a href="#" onClick={goLogin}>
							Pulsa aquí para iniciar sesión
						</a>
					</div>
					<Form className="loginBg p-4 m-4" onSubmit={(e) => tryRegister(e, username, email, password, rpassword)}>
						{error && <Alert variant={'danger'}>{error}</Alert>}
						<Form.Group style={{ textAlign: 'left' }} className="mt-2">
							<Form.Label>Nombre de usuario</Form.Label>
							<Form.Control
								type="text"
								required
								placeholder="Usuario"
								value={username}
								onChange={(e) => setUsername(e.currentTarget.value)}
							/>
						</Form.Group>
						<Form.Group style={{ textAlign: 'left' }} className="mt-4">
							<Form.Label>Dirección de correo electrónico</Form.Label>
							<Form.Control
								type="text"
								required
								placeholder="Correo electrónico"
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
						<Form.Group style={{ textAlign: 'left' }} className="mt-4">
							<Form.Label>Repita contraseña</Form.Label>
							<Form.Control
								type="password"
								required
								placeholder="Repite tu contraseña"
								value={rpassword}
								onChange={(e) => setRPassword(e.currentTarget.value)}
							/>
						</Form.Group>
						<Button style={{ width: '100%' }} className="mt-4 mb-2" variant="primary" type="submit">
							{isLoading ? 'Finalizando registro...' : 'Finalizar registro'}
						</Button>
					</Form>
				</Container>
			</Container>
		</div>
	);
};

export default Register;
