import { Container, Card, Button, Accordion, ListGroup, Image } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faStar } from '@fortawesome/free-solid-svg-icons';

const OfferSellerDescription = ({ offer }) => {
	return (
		<div id="seller" className="mt-4 offerSellerDescription" style={{ textAlign: 'left' }}>
			<h2>Acerca del vendedor</h2>
			<Container className="sellerDescriptionHeader" fluid>
				<div className='mt-3' style={{width: '150px', height: '150px'}}>
					<Image className="empImg" src={offer.empleadores[0].image} />
				</div>
				<p className="text-muted mt-2" style={{ fontWeight: 'bold' }}>
					{offer.empleadores[0].nombre}
				</p>
				<div className="sellerDescriptionRating mt-2">
					{[ ...Array(Math.ceil(offer.promedio ? offer.promedio : 1)) ].map((x, i) => (
						<FontAwesomeIcon key={i} className="m-0" icon={faStar} style={{ color: 'darkorange' }} />
					))}
					<p className="m-0" style={{ color: 'darkgrey' }}>
						({offer.promedio ? offer.promedio : '0'})
					</p>
				</div>
				<Button className="mt-4" style={{ width: '100%' }} variant="outline-secondary">
					Contactar al vendedor
				</Button>
				<Card className="mt-4 offerSellerDescriptionCard">
					<Card.Body className="offerPriceBody">
						<Card.Subtitle className="mt-2 text-muted" style={{ width: '100%', textAlign: 'left' }}>
							País
						</Card.Subtitle>
						<Card.Subtitle
							className="mt-2"
							style={{ width: '100%', textAlign: 'left', fontWeight: 'bold' }}
						>
							{offer.empleadores[0].pais}
						</Card.Subtitle>
						<Card.Subtitle className="mt-2 text-muted" style={{ width: '100%', textAlign: 'left' }}>
							Idioma
						</Card.Subtitle>
						<Card.Subtitle
							className="mt-2"
							style={{ width: '100%', textAlign: 'left', fontWeight: 'bold' }}
						>
							{offer.idiomas}
						</Card.Subtitle>
						<Card.Subtitle className="mt-2 text-muted" style={{ width: '100%', textAlign: 'left' }}>
							Tipo
						</Card.Subtitle>
						<Card.Subtitle
							className="mt-2"
							style={{ width: '100%', textAlign: 'left', fontWeight: 'bold' }}
						>
							{offer.empleadores[0].tipo}
						</Card.Subtitle>
					</Card.Body>
					<ListGroup variant="flush">
						<Accordion defaultActiveKey="0">
							<Accordion.Item eventKey="0">
								<Accordion.Header className="text-muted" style={{ fontWeight: 'bold' }}>
									<Card.Subtitle className="text-muted">Descripción</Card.Subtitle>
								</Accordion.Header>
								<Accordion.Body style={{whiteSpace: 'pre-wrap'}}>{offer.empleadores[0].descripcion}</Accordion.Body>
							</Accordion.Item>
						</Accordion>
					</ListGroup>
				</Card>
			</Container>
		</div>
	);
};

export default OfferSellerDescription;
