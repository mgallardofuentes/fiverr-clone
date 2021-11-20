import { Navbar, Nav, NavDropdown, Container, Form, FormControl, Button, Offcanvas } from 'react-bootstrap';
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import categories from '../../categories.json';

const NavbarComp = ({ setSearchTerm, register, offerNav }) => {
	const [ path, setPath ] = useState(window.location.pathname);
	const { currentCategory } = useParams();

	useEffect(() => {
		setPath(window.location.pathname);	
	}, []);

	const isLogged = localStorage.getItem('login_data') ? true : false;

	const doLogout = (e) => {
		e.preventDefault();
		localStorage.removeItem('login_data');
		window.location.reload();
	};

	const NavBarHome = (
		<Navbar bg="light" expand="lg">
			<Container fluid>
				<Navbar.Brand as={Link} to={'/'}>!Fiverr</Navbar.Brand>
				<Navbar.Toggle aria-controls="navbarScroll" />
				<Navbar.Collapse id="navbarScroll">
					<Nav className="me-auto my-2 my-lg-0" navbarScroll>
						<Nav.Link as={Link} to={'/categorias/0'}>
							Ofertas
						</Nav.Link>
						<NavDropdown title="Categorias" id="navbarScrollingDropdown">
							{categories.map((category) => {
								return (
									<NavDropdown.Item
										key={category.id}
										as={Link}
										to={'/categorias/' + (category.id)}
									>
										{category.nombre}
									</NavDropdown.Item>
								);
							})}
						</NavDropdown>
						{isLogged && (
							<NavDropdown title="Usuario" id="navbarScrollingDropdownSession">
								<NavDropdown.Item onClick={doLogout}>Cerrar sesión</NavDropdown.Item>
							</NavDropdown>
						)}
					</Nav>
						<Form id="navbarForm" className="d-flex home">
							<FormControl
								type="search"
								placeholder="Search"
								className="me-2"
								aria-label="Search"
								onChange={(e) => setSearchTerm(e.target.value)}
							/>
							<Link to={currentCategory ? `/categorias/${currentCategory}` : `/categorias/0`}>
								<Button type="submit" variant="outline-primary">
									Search
								</Button>
							</Link>
						</Form>
				</Navbar.Collapse>
			</Container>
		</Navbar>
	);

	if(path === "/" || offerNav) return NavBarHome;

	return (
		<Container fluid style={{padding: '0'}}>
			{isLogged && (
				<Navbar bg="light" expand="lg">
					<Container fluid >
					<Navbar.Brand as={Link} to={'/'}>!Fiverr</Navbar.Brand>
						<Navbar.Toggle aria-controls="navbarScroll" />
						<Navbar.Collapse id="navbarScroll">
							<Nav className="me-auto my-2 my-lg-0" navbarScroll>
								<Nav.Link as={Link} to={'/categorias/0'}>
									Ofertas
								</Nav.Link>
								<NavDropdown title="Categorias" id="navbarScrollingDropdown">
									{categories.map((category) => {
										return (
											<NavDropdown.Item
												key={category.id}
												as={Link}
												to={'/categorias/' + category.id}
											>
												{category.nombre}
											</NavDropdown.Item>
										);
									})}
								</NavDropdown>
								{isLogged && (
									<NavDropdown title="Sesión" id="navbarScrollingDropdownSession">
										<NavDropdown.Item onClick={doLogout}>Cerrar sesión</NavDropdown.Item>
									</NavDropdown>
								)}
							</Nav>
								<Form id="navbarForm" className="d-flex hidden" onSubmit={(e) => e.preventDefault()}>
									<FormControl
										type="search"
	
										onChange={(e) => {
											if (e.which === 13 || e.which === 27)
												e.preventDefault()
											setSearchTerm(e.target.value);
										}}
										placeholder="Search"
										className="me-2"
										aria-label="Search"
									/>
								</Form>
						</Navbar.Collapse>
					</Container>
				</Navbar>
			)}
			{!isLogged && (
				<Navbar bg="light" expand="lg">
					<Container fluid>
						<Navbar.Brand href="#">Fiverr</Navbar.Brand>
						<Nav className="me-auto my-2 my-lg-0" />
						<Form className="d-flex">
							{!register && (
								<Button className="m-2" variant="primary" as={Link} to={'/register'}>
									Registro
								</Button>
							)}
							{register && (
								<Button className="m-2" variant="primary" as={Link} to={'/login'}>
									Login
								</Button>
							)}
						</Form>
					</Container>
				</Navbar>
			)}
		</Container>
	);
};

export default NavbarComp;
