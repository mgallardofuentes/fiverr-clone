import { Card, ListGroupItem, ListGroup, Image } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faStar } from '@fortawesome/free-solid-svg-icons';
import LazyLoad from 'react-lazyload';

const CardComp = ({ offer, currentCategory, i }) => {
	const setImage = () => {
		if (offer.empleadores.length > 0) return offer.empleadores[0].image;
		return 'undefined';
	};
	const setName = () => {
		if (offer.empleadores.length > 0) return offer.empleadores[0].nombre;
		return 'undefined';
	};

	const setType = () => {
		if (offer.empleadores.length > 0) return offer.empleadores[0].tipo;
		return 'undefined';
	};
	return (
		<Card
			className="m-3 card"
			as={Link}
			to={`/categorias/${currentCategory}/ofertas/${offer.id}`}
			style={{ textDecoration: 'none', color: 'inherit' }}
		>
			<LazyLoad height="100%" offset={600}>
				<Card.Img variant="top" className="mh-100 card-img" src={offer.image + i} />
			</LazyLoad>
			<Card.Body
				style={{
					display: 'flex',
					flexDirection: 'column',
					justifyContent: 'space-between',
					alignItems: 'flex-start'
				}}
			>
				<LazyLoad>
					<div className="m-1">
						<Image style={{ width: '30px', height: '30px' }} src={setImage()} roundedCircle />
						<p className="m-2" style={{ display: 'inline-block' }}>
							{setName()}
						</p>
						<p
							className="m-2"
							style={{ display: 'inline-block', color: 'rgb(90,90,90)', fontSize: '12px' }}
						>
							{setType()}
						</p>
					</div>
				</LazyLoad>
				<Card.Text className="m-1" style={{ textAlign: 'left', height: '100%' }}>
					{offer.nombre}
				</Card.Text>
				<Card.Text className="m-1" style={{ color: 'darkorange', float: 'left' }}>
					{' '}
					<FontAwesomeIcon icon={faStar} />
					<span>
						{' '}
						{offer.promedio ? offer.promedio : '0'}
						<span style={{ color: 'darkgrey' }}>({offer.opiniones ? offer.opiniones : '0'})</span>
					</span>
				</Card.Text>
			</Card.Body>
			<ListGroup variant="flush">
				<ListGroupItem className="mt-3">
					<Card.Text style={{ float: 'left' }}>A partir de</Card.Text>
					<Card.Text style={{ float: 'right', fontWeight: 'bold' }} className="">
						{offer.precio}€
					</Card.Text>
				</ListGroupItem>
			</ListGroup>
		</Card>
	);
};

export default CardComp;
