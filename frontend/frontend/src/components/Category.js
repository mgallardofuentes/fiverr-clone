import { Navigate, useParams } from 'react-router';
import { Container, Spinner, Alert, Pagination, Form, FormControl } from 'react-bootstrap';
import CategoryNavbarComp from './navbar/CategoryNavbarComp';
import CardComp from './CardComp';
import NavbarComp from './navbar/NavbarComp';
import { useState, useEffect, useContext } from 'react';
import FilterNavbarComp from './navbar/FilterNavbarComp';
import categories from '../categories.json';
import { appContext } from '../App';
import BottomNavbar from './navbar/BottomNavbar';
import { Link } from 'react-router-dom';

const ELEMENTS_PER_PAGE = 10;

const Category = ({ setSearchTerm, searchTerm }) => {
	let { currentCategory } = useParams();
	const [ loading, setLoading ] = useState('true');
	const [ offers, setoffers ] = useState('');
	const [ filter, setFilter ] = useState('');
	const [ order, setOrder ] = useState('');
	const [ countries, setCountries ] = useState('todos');
	const [ sellerRank, setSellerRank ] = useState('');
	const [ language, setLanguage ] = useState('');
	const [ min, setMin ] = useState(-1);
	const [ max, setMax ] = useState(-1);
	const { token } = useContext(appContext);
	const [ currentOffers, setCurrentOffers ] = useState('');
	const [ offersPages, setOffersPages ] = useState([0]);
	const [ currentPage, setCurrentPage ] = useState(1);

	useEffect(
		() => {
			(async () => {
				const tokenHeader = {
					headers: {
						Authorization: 'Bearer ' + token
					}
				};
				if (currentCategory === '0') {
					let response = await fetch('https://proyectofiverrequipo3.herokuapp.com/api/trabajos', tokenHeader);
					const responseData = await response;
					if (responseData.status !== 200) {
						localStorage.removeItem('login_data');
						window.location.reload();
					} else {
						const details = await responseData.json();
						setoffers(details);
						setCurrentOffers(details);
						if(details.length > ELEMENTS_PER_PAGE) {
							setOffersPages(Math.ceil(details.length / ELEMENTS_PER_PAGE));
							setCurrentOffers(details.slice(0, ELEMENTS_PER_PAGE));
						}
						setLoading(false);
					}

					setLoading(false);
				} else {
					let response = await fetch(
						'https://proyectofiverrequipo3.herokuapp.com/api/categorias/' + currentCategory,
						tokenHeader
					);
					const responseData = await response;
					if (responseData.status !== 200) {
						localStorage.removeItem('login_data');
						window.location.reload();
					} else {
						const details = await responseData.json();
						setoffers(details);
						setCurrentOffers(details);
						setLoading(false);
					}
				}
			})();
		},
		[ token, currentCategory ]
	);

	const applyFilter = (newFilter) => {
		if (newFilter === filter) setFilter('');
		else setFilter(newFilter);
	};

	const applyOrder = (newOrder) => {
		if (newOrder === order) setOrder('');
		else setOrder(newOrder);
	};

	const filterByPrice = (offer) => {
		if (min <= offer.precio && max >= offer.precio) return offer;
	};

	const filterByCountry = (offer) => {
		if (
			offer.pais.toLowerCase().replace(' ', '') === countries ||
			offer.empleadores[0].pais.toLowerCase().replace(' ', '') === countries
		)
			return offer;
	};

	const filterBySellerRank = (offer) => {
		if (offer.empleadores[0].tipo.toLowerCase() === sellerRank) return offer;
	};

	const filterByLanguage = (offer) => {
		if (offer.idiomas.toLowerCase() === language) return offer;
	};

	const orderOffers = (first, second) => {
		if (order === 'countryHigh') return first.pais < second.pais ? 1 : -1;
		else if (order === 'countryLow') return first.empleadores[0].pais > second.empleadores[0].pais ? 1 : -1;
		else if (order === 'priceHigh') return first.precio < second.precio ? 1 : -1;
		else if (order === 'priceLow') return first.precio > second.precio ? 1 : -1;
		else if (order === 'scoreHigh') return first.promedio < second.promedio ? 1 : -1;
		else if (order === 'scoreLow') return first.promedio > second.promedio ? 1 : -1;
	};

	let i = 0;
	
	const paginationItems = () => {
		let items = [];
		items.push(<Pagination.Prev key={0} disabled={currentPage === 1} onClick={() => setOffersForPage(currentPage-1)}/>);
		for(let i = 0; i < offersPages; i++) {
			items.push(<Pagination.Item key={i+1} active={currentPage == i+1} onClick={() => setOffersForPage(i+1)}>{i+1}</Pagination.Item>);
		}
		items.push(<Pagination.Next key={offersPages+1} disabled={currentPage === offersPages} onClick={() => setOffersForPage(currentPage+1)}/>);
		return items;
	}

	const setOffersForPage = (page) => {
		const fromIndex = ELEMENTS_PER_PAGE * (page - 1);
		const toIndex = fromIndex + ELEMENTS_PER_PAGE;
		setCurrentOffers(offers.slice(fromIndex, toIndex));
		setCurrentPage(page);
	}

	return (
		<div>
			<div className="offerNavbar">
			<NavbarComp setSearchTerm={setSearchTerm} searchTerm={searchTerm} offers={offers} />
			<FilterNavbarComp
				applyFilter={applyFilter}
				applyOrder={applyOrder}
				setMin={setMin}
				setMax={setMax}
				setCountries={setCountries}
				setSellerRank={setSellerRank}
				setLanguage={setLanguage}
			/>
			
			<CategoryNavbarComp categories={categories} home={false}/>
			<Form id="home" className="d-flex m-4">
							<FormControl
								type="search"
								placeholder="Search"
								className="me-2"
								aria-label="Search"
								onChange={(e) => setSearchTerm(e.target.value)}
							/>
						</Form>
			</div>
			<Container id="offer-wrapper" fluid className="offer-wrapper m-0">
				{currentOffers.length > 0 ? (
					currentOffers
						.filter((offer) => {
							if (searchTerm === '') return offer;
							else if (offer.nombre.toLowerCase().includes(searchTerm.toLowerCase())) return offer;
							else if (offer.empleadores[0].nombre.toLowerCase().includes(searchTerm.toLowerCase()))
								return offer;
							else return null;
						})
						.filter((offer) => (min !== -1 && max !== -1 ? filterByPrice(offer) : offer))
						.filter((offer) => (countries !== 'todos' ? filterByCountry(offer) : offer))
						.filter((offer) => (sellerRank !== '' ? filterBySellerRank(offer) : offer))
						.filter((offer) => (language !== '' ? filterByLanguage(offer) : offer))
						.sort(orderOffers)
						.map((offer) => {
							i++;
							return <CardComp key={offer.id} offer={offer} currentCategory={currentCategory} i ={i} />;
						})
				) : loading ? (
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
				) : (
					<div
						style={{
							height: '48.5vh',
							display: 'flex',
							justifyContent: 'center',
							alignItems: 'center'
						}}
					>
						<Alert variant="primary">
							<Alert.Heading>
								No hemos encontrado ninguna oferta de {categories[currentCategory].nombre}
							</Alert.Heading>
							<hr />
							<p className="mb-0">
								Puedes ver todas nuestras ofertas haciendo click en{' '}
								<Alert.Link as={Link} to={'/categorias/0'}>
									todas las ofertas
								</Alert.Link>
							</p>
						</Alert>
					</div>
				)}
			</Container>
			<Pagination className="offer-wrapper mt-2 mb-4">
				{
					offersPages === 1 ? (
						<>
							<Pagination.Prev disabled />
							<Pagination.Item active>1</Pagination.Item>
							<Pagination.Next disabled />
						</>
					) : paginationItems()
				}
			</Pagination>
			<BottomNavbar />
		</div>
	);
};

export default Category;
