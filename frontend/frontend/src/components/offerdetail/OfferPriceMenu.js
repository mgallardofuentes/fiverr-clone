import { Tabs, Tab, Card, Button } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCheck } from '@fortawesome/free-solid-svg-icons';

const OfferPriceMenu = ({ offer }) => {
	return (
		<div className="offerPriceMenu">
			<Tabs defaultActiveKey="home" id="uncontrolled-tab-example" className="">
				<Tab className="offerPriceTab" eventKey="home" title="Básico">
					<Card style={{ width: '100%' }}>
						<Card.Body className="offerPriceBody">
							<Card.Title style={{ width: '50%', textAlign: 'left' }}>BRONCE</Card.Title>
							<Card.Title style={{ display: 'inline-block', textAlign: 'right', width: '50%' }}>
								{offer.precio}€
							</Card.Title>
							<Card.Subtitle className="mt-4 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								Plan más básico
							</Card.Subtitle>
							<Card.Subtitle
								className="mt-4"
								style={{ width: '100%', textAlign: 'left', fontWeight: 'bold' }}
							>
								Detalles del plan
							</Card.Subtitle>
							<Card.Text className="mt-2 mb-0 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								{' '}
								<FontAwesomeIcon style={{ color: 'green' }} className="" icon={faCheck} />{' '}
								Característica 1
							</Card.Text>
							<Card.Text className="mt-1 mb-0 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								{' '}
								<FontAwesomeIcon className="" icon={faCheck} /> Característica 2
							</Card.Text>
							<Card.Text className="mt-1 mb-0 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								{' '}
								<FontAwesomeIcon style={{ color: 'green' }} className="" icon={faCheck} />{' '}
								Característica 3
							</Card.Text>
							<Card.Text className="mt-1 mb-0 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								{' '}
								<FontAwesomeIcon className="" icon={faCheck} /> Característica 4
							</Card.Text>
							<Card.Text className="mt-1 mb-0 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								{' '}
								<FontAwesomeIcon className="" icon={faCheck} /> Característica 5
							</Card.Text>
							<Button className="mt-4" style={{ width: '100%' }} variant="primary">
								Continuar ({offer.precio}€)
							</Button>
							<Button className="mt-4" style={{ width: '100%' }} variant="outline-secondary">
								Contactar al vendedor
							</Button>
						</Card.Body>
					</Card>
				</Tab>
				<Tab eventKey="profile" title="Standard">
					<Card style={{ width: '100%' }}>
						<Card.Body className="offerPriceBody">
							<Card.Title style={{ width: '50%', textAlign: 'left' }}>PLATA</Card.Title>
							<Card.Title style={{ display: 'inline-block', textAlign: 'right', width: '50%' }}>
								{offer.precio * 2}€
							</Card.Title>
							<Card.Subtitle className="mt-4 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								Plan con casi todo lo que necesitas
							</Card.Subtitle>
							<Card.Subtitle
								className="mt-4"
								style={{ width: '100%', textAlign: 'left', fontWeight: 'bold' }}
							>
								Detalles del plan
							</Card.Subtitle>
							<Card.Text className="mt-2 mb-0 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								{' '}
								<FontAwesomeIcon style={{ color: 'green' }} className="" icon={faCheck} />{' '}
								Característica 1
							</Card.Text>
							<Card.Text className="mt-1 mb-0 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								{' '}
								<FontAwesomeIcon className="" icon={faCheck} /> Característica 2
							</Card.Text>
							<Card.Text className="mt-1 mb-0 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								{' '}
								<FontAwesomeIcon style={{ color: 'green' }} className="" icon={faCheck} />{' '}
								Característica 3
							</Card.Text>
							<Card.Text className="mt-1 mb-0 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								{' '}
								<FontAwesomeIcon className="" icon={faCheck} /> Característica 4
							</Card.Text>
							<Card.Text className="mt-1 mb-0 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								{' '}
								<FontAwesomeIcon style={{ color: 'green' }} className="" icon={faCheck} />{' '}
								Característica 5
							</Card.Text>
							<Button className="mt-4" style={{ width: '100%' }} variant="primary">
								Continuar ({offer.precio * 2}€)
							</Button>
							<Button className="mt-4" style={{ width: '100%' }} variant="outline-secondary">
								Contactar al vendedor
							</Button>
						</Card.Body>
					</Card>
				</Tab>
				<Tab eventKey="contact" title="Premium">
					<Card style={{ width: '100%' }}>
						<Card.Body className="offerPriceBody">
							<Card.Title style={{ width: '50%', textAlign: 'left' }}>ORO</Card.Title>
							<Card.Title style={{ display: 'inline-block', textAlign: 'right', width: '50%' }}>
								{offer.precio * 3}€
							</Card.Title>
							<Card.Subtitle className="mt-4 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								Plan para los que quieren todo
							</Card.Subtitle>
							<Card.Subtitle
								className="mt-4"
								style={{ width: '100%', textAlign: 'left', fontWeight: 'bold' }}
							>
								Detalles del plan
							</Card.Subtitle>
							<Card.Text className="mt-2 mb-0 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								{' '}
								<FontAwesomeIcon style={{ color: 'green' }} className="" icon={faCheck} />{' '}
								Característica 1
							</Card.Text>
							<Card.Text className="mt-1 mb-0 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								{' '}
								<FontAwesomeIcon style={{ color: 'green' }} className="" icon={faCheck} />{' '}
								Característica 2
							</Card.Text>
							<Card.Text className="mt-1 mb-0 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								{' '}
								<FontAwesomeIcon style={{ color: 'green' }} className="" icon={faCheck} />{' '}
								Característica 3
							</Card.Text>
							<Card.Text className="mt-1 mb-0 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								{' '}
								<FontAwesomeIcon style={{ color: 'green' }} className="" icon={faCheck} />{' '}
								Característica 4
							</Card.Text>
							<Card.Text className="mt-1 mb-0 text-muted" style={{ width: '100%', textAlign: 'left' }}>
								{' '}
								<FontAwesomeIcon style={{ color: 'green' }} className="" icon={faCheck} />{' '}
								Característica 5
							</Card.Text>
							<Button className="mt-4" style={{ width: '100%' }} variant="primary">
								Continuar ({offer.precio * 3}€)
							</Button>
							<Button className="mt-4" style={{ width: '100%' }} variant="outline-secondary">
								Contactar al vendedor
							</Button>
						</Card.Body>
					</Card>
				</Tab>
			</Tabs>
		</div>
	);
};

export default OfferPriceMenu;
