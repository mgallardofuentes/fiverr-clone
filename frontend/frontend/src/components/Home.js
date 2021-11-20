import offers from '../test.json';
import { Link } from 'react-router-dom';
import { Container, Form, FormControl, Button } from 'react-bootstrap';
import CategoryNavbarComp from './navbar/CategoryNavbarComp'
import categories from '../categories.json';
import NavbarComp from './navbar/NavbarComp';
const Home = ({ setSearchTerm, searchTerm}) => {
	
	
	return (
		<div>
			<NavbarComp setSearchTerm={setSearchTerm} searchTerm={searchTerm} offers={offers} />
			<div className="background" />
			<Container fluid className="home-wrapper">
				<Container className="m-2 header-div">
					<h1 className="title m-3" style={{ color: 'white', textAlign: 'left' }}>
						Encuentra los servicios ideales para tu negocio
					</h1>
					<Form className="d-flex homeForm m-3 ">
						<FormControl
							type="search"
							key="1"
							placeholder="Search"
							className=" homeInput"
							aria-label="Search"
							onChange={(e) => {
								setSearchTerm(e.target.value);
							}}
						/>
						<Link to={'/categorias/0'}>
							<Button style={{ width: '100%' }} className="" type="submit" variant="primary">
								Search
							</Button>
						</Link>
					</Form>
				</Container>
				<Container className="m-2 header-div">
					<h5 className="m-3" style={{ color: 'white', textAlign: 'left' }}>
						O busca por categorías
					</h5>
					<CategoryNavbarComp categories={categories} home={true}/>
				</Container>
			</Container>
		</div>
	);
};

export default Home;
