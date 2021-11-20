import { Image, Carousel } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faStar } from '@fortawesome/free-solid-svg-icons';

const OfferHeader = ({ offer }) => {
	return (
		<div id="header" className="offerHeader">
			<h1 className="mt-2" style={{ textAlign: 'left' }}>
				{offer.nombre}
			</h1>

			<div className="mt-2 sellerTitle">
				<div>
					<Image className="mt-2 sellerImg" src={offer.empleadores[0].image} />
				</div>
				<div className="sellerData">
					<p className="m-1" style={{ fontWeight: 'bold' }}>
						{offer.empleadores[0].nombre}
					</p>
					<p className="m-1" style={{ color: 'darkgrey' }}>
						{offer.empleadores[0].tipo}
					</p>
				</div>
				<div className="sellerOpinions">
				{[ ...Array(Math.ceil(offer.promedio ? offer.promedio : 1)) ].map((x, i) => (
						<FontAwesomeIcon key={i} className="m-0" icon={faStar} style={{ color: 'darkorange' }} />
					))}
					<p className="m-0" style={{ color: 'darkgrey' }}>
						({offer.promedio ? offer.promedio : '0'})
					</p>
				</div>
			</div>
			<div className="carrouselDiv">
				<Carousel className="mt-4">
					<Carousel.Item>
						<img
							className="d-block w-100"
							style={{ width: '100%', height: '30vw', objectFit: 'cover' }}
							src={offer.image}
							alt="First slide"
						/>
					</Carousel.Item>
					{[ ...Array(Math.floor(Math.random() * (10 - 2) + 2)) ].map((x, i) => (
						<Carousel.Item key={i}>
							<img
								className="d-block w-100"
								style={{ width: '100%', height: '50vw', objectFit: 'cover' }}
								src={offer.image + i}
								alt="Second slide"
							/>
						</Carousel.Item>
					))}
				</Carousel>
			</div>
		</div>
	);
};

export default OfferHeader;
