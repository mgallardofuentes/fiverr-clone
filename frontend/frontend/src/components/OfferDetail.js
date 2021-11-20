import { Container, Spinner, Navbar, Nav, Form, FormControl, Button } from 'react-bootstrap';
import OfferDescription from './offerdetail/OfferDescription';
import OfferSellerDescription from './offerdetail/OfferSellerDescription';
import OfferHeader from './offerdetail/OfferHeader';
import OfferPriceMenu from './offerdetail/OfferPriceMenu';
import NavbarComp from './navbar/NavbarComp';
import { Link } from 'react-router-dom';
import CategoryNavbarComp from './navbar/CategoryNavbarComp';
import BottomNavbar from './navbar/BottomNavbar';
import { Navigate, useParams } from 'react-router-dom';
import categories from '../categories.json';
import { useState, useEffect, useContext } from 'react';
import { appContext } from '../App';
import OfferRecommended from './offerdetail/OfferRecommended';

const OfferDetail = ({ setSearchTerm }) => {
	const {currentCategory} = useParams();
	const [ offer, setOffer ] = useState('');
	const [ offers, setOffers ] = useState('');
	const { id } = useParams();
	const { token } = useContext(appContext);

	useEffect(
		() => {
			(async () => {
				const tokenHeader = {
					headers: {
						Authorization: 'Bearer ' + token
					}
				};
				let response = await fetch(
					`https://proyectofiverrequipo3.herokuapp.com/api/trabajos/${id}`,
					tokenHeader
				);
				const responseData = await response;
				if (responseData.status !== 200) {
					localStorage.removeItem('login_data');
					window.location.reload();
				} else {
					const details = await responseData.json();
					setOffer(details);
				}
			})();
			(async () => {
				const tokenHeader = {
					headers: {
						Authorization: 'Bearer ' + token
					}
				};
				let response = await fetch('https://proyectofiverrequipo3.herokuapp.com/api/trabajos', tokenHeader);
				const responseData = await response;
				if (responseData.status !== 200) {
					localStorage.removeItem('login_data');
					window.location.reload();
				} else {
					const details = await responseData.json();
					setOffers(details);
				}
			})();
		},
		[ id, token ]
	);

	return (
		<div style={{ width: '100%', padding: '0' }}>
			{console.log(offer)}
			{offer ? (
				<div className="" style={{ width: '100%', padding: '0' }}>
					<div className='offerNavbar'>
					<NavbarComp setSearchTerm={setSearchTerm} offerNav={true} />
					<CategoryNavbarComp className="p-5" categories={categories} home={false} />
					<Form id="home" className="d-flex m-4">
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
					<Navbar className="descriptionNavbar" bg="light" expand="lg">
						<Nav className="me-auto noResponsive">
							<Nav.Link className="descriptionLink left" href="#header">
								Oferta
							</Nav.Link>
							<Nav.Link className="descriptionLink" href="#description">Descripción</Nav.Link>
							<Nav.Link className="descriptionLink" href="#seller">Vendedor</Nav.Link>
							<Nav.Link className="descriptionLink" href="#recommended">Relacionado</Nav.Link>
						</Nav>
					</Navbar>
					</div>
					<Container className="offerDetail" fluid>
						<OfferHeader offer={offer} />
						<OfferPriceMenu offer={offer} />
						<OfferDescription offer={offer} />
						<OfferSellerDescription offer={offer} />
						<OfferRecommended offers={offers} />
					</Container>
				</div>
			) : (
				<div
					style={{
						height: '49vh',
						width: '100%',
						display: 'flex',
						justifyContent: 'center',
						alignItems: 'center'
					}}
				>
					<Spinner animation="border" role="status" variant="primary">
						<span className="visually-hidden">Loading...</span>
					</Spinner>
				</div>
			)}
			<BottomNavbar />
		</div>
	);
};

export default OfferDetail;
