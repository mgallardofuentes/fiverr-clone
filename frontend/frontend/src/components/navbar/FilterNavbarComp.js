import { Navbar, Container } from 'react-bootstrap';
import { useParams } from 'react-router-dom';
import FilterModal from './FilterModal';
import SortModal from './SortModal';
import categories from '../../categories.json';

const FilterNavbarComp = ({ applyFilter, applyOrder, setMin, setMax, setCountries, setSellerRank, setLanguage }) => {
	const { currentCategory } = useParams();
	return (
		<Navbar expand="lg">
			<div className="filterNavbar p-2">
				<h2 className="m-2" style={{ textAlign: 'left' }}>{categories[currentCategory].nombre}</h2>
				<Container className="filter-nav">
					<FilterModal
						applyFilter={applyFilter}
						setMin={setMin}
						setMax={setMax}
						setCountries={setCountries}
						setSellerRank={setSellerRank}
						setLanguage={setLanguage}
					/>
					<SortModal applyOrder={applyOrder} />
				</Container>
			</div>
		</Navbar>
	);
};

export default FilterNavbarComp;
