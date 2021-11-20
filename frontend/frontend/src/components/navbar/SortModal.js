import { Button, Dropdown, Modal } from 'react-bootstrap';
import { useState } from 'react';
import { faSort } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
const SortModal = ({ applyOrder }) => {
	const [ fullscreen, setFullscreen ] = useState(true);
	const [ show, setShow ] = useState(false);

	function handleShow() {
		setFullscreen('sm-down');
		setShow(true);
	}
	const handleClose = () => setShow(false);

	return (
		<div>
			<Button variant="outline-primary" className="m-2" onClick={() => handleShow()}>
				<FontAwesomeIcon icon={faSort} /> Ordenar
			</Button>

			<Modal className="modal" show={show} fullscreen={fullscreen} onHide={() => setShow(false)}>
				<Modal.Header>
					<Modal.Title>Ordenar por</Modal.Title>
				</Modal.Header>
				<Modal.Body className="modalBody">
					<Dropdown.Item className="p-3" onClick={() => applyOrder('countryHigh')}>
						País A-Z
					</Dropdown.Item>
					<Dropdown.Item className="p-3" onClick={() => applyOrder('countryLow')}>
						País Z-A
					</Dropdown.Item>
					<Dropdown.Item className="p-3" onClick={() => applyOrder('priceHigh')}>
						Precio de mayor a menor
					</Dropdown.Item>
					<Dropdown.Item className="p-3" onClick={() => applyOrder('priceLow')}>
						Precio de menor a mayor
					</Dropdown.Item>
					<Dropdown.Item className="p-3" onClick={() => applyOrder('scoreHigh')}>
						Mejor valorados
					</Dropdown.Item>
					<Dropdown.Item className="p-3" onClick={() => applyOrder('scoreLow')}>
						Peor valorados
					</Dropdown.Item>
				</Modal.Body>
				<Modal.Footer>
					<Button className="m-2" style={{ width: '100%' }} onClick={handleClose}>
						Ordenar
					</Button>
				</Modal.Footer>
			</Modal>
		</div>
	);
};

export default SortModal;
