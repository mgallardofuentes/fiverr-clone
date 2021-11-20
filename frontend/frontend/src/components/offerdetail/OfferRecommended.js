import { useParams } from 'react-router-dom';
import { Carousel, Spinner } from 'react-bootstrap';
import OfferCardComp from './OfferCardComp';

const OfferRecommended = ({ offers }) => {
	const { currentCategory, id } = useParams();

	let c = 0;
	return (
		<div id="recommended" className="mt-4 offerCarousel">
			<h2 style={{ textAlign: 'left' }}>Quizás te pueda interesar</h2>
			<Carousel className="mt-4 offerCarouselSlide">
				{offers ? (
					offers
						.filter(
							(offer) =>
								currentCategory !== '0' ? offer.categorias[0].id === parseInt(currentCategory) : offer
						)
						.filter((offer) => {
							if (c !== offers.length && offer.id !== id) {
								c++;
								return offer;
							} else return null;
						})
						.map((offer) => {
							return (
								<Carousel.Item key={offer.id}>
									<OfferCardComp
										style={{ width: '100%' }}
										offer={offer}
										currentCategory={currentCategory}
									/>
								</Carousel.Item>
							);
						})
				) : (
					<div style={{height: '49vh', width: '100%', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
						<Spinner animation="border" role="status" variant="primary">
							<span className="visually-hidden">Loading...</span>
						</Spinner>
					</div>
				)}
			</Carousel>
		</div>
	);
};

export default OfferRecommended;
