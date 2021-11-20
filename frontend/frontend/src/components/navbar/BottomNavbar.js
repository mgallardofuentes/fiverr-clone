import { Dropdown, Navbar, Nav } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import categories from '../../categories.json';
const BottomNavbar = () => {
	const doLogout = (e) => {
		e.preventDefault();
		localStorage.removeItem('login_data');
		window.location.reload();
	};

	return (
		<div className="bottomNavbar">
			<Dropdown drop="up" style={{ width: '100%' }}>
				<Dropdown.Toggle
					className="dropdownPad"
					style={{ width: '100%', textAlign: 'left', borderRadius: '0' }}
					variant="light"
					id="dropdown-basic"
				>
					Categorías
				</Dropdown.Toggle>

				<Dropdown.Menu style={{ width: '100%', backgroundColor: '#f9fafb' }}>
					{categories.map((category) => {
						return (
							<Dropdown.Item
								className="mt-2 mb-2"
								key={category.id}
								as={Link}
								to={'/categorias/' + category.id}
							>
								{category.nombre}
							</Dropdown.Item>
						);
					})}
				</Dropdown.Menu>
			</Dropdown>
			<Dropdown drop="up" style={{ width: '100%' }}>
				<Dropdown.Toggle
					className="dropdownPad"
					style={{ width: '100%', textAlign: 'left', borderRadius: '0' }}
					variant="light"
					id="dropdown-basic"
				>
					Usuario
				</Dropdown.Toggle>

				<Dropdown.Menu style={{ width: '100%', backgroundColor: '#f9fafb' }}>
					<Dropdown.Item className="mt-2 mb-2" onClick={doLogout}>
						Cerrar sesión
					</Dropdown.Item>
				</Dropdown.Menu>
			</Dropdown>

			<Navbar bg="light" className="p-0">
				<Nav className="me-auto dropdownPad">
					<Nav.Link className="p-0" style={{ color: '#000' }} as={Link} to={'/'}>
						Home
					</Nav.Link>
				</Nav>
			</Navbar>
		</div>
	);
};

export default BottomNavbar;
