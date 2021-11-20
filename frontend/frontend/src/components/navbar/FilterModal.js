import { Button, Dropdown, Modal, Form } from 'react-bootstrap';
import { useState } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFilter } from '@fortawesome/free-solid-svg-icons';
const FilterModal = ({ applyFilter, setMin, setMax, setCountries, setSellerRank, setLanguage }) => {
	const [ fullscreen, setFullscreen ] = useState(true);
	const [ show, setShow ] = useState(false);
	const [ min, setMinAux ] = useState('0');
	const [ max, setMaxAux ] = useState('0');
  const [country, setCountry] = useState('todos')
  const [checked, setChecked] = useState('') 
  const [checkedLang, setCheckedLang] = useState('') 

	function handleShow() {
		setFullscreen('m-down');
		setShow(true);
	}
	const handleClose = () => {
		if (isNaN(parseInt(min)) || isNaN(parseInt(max)) || (min === '0' && max === '0')) {
			setMin(-1);
			setMax(-1);
		} else {
			setMin(min);
			setMax(max);
		}
		setShow(false);
	};

	const handlePrice = (price) => (e) => {
		if (price === 'min') {
			setMinAux(e.target.value);
		} else {
			setMaxAux(e.target.value);
		}
	};

	const handleCountry = (e) => {
		setCountries(e.target.value);
    setCountry(e.target.value)
	};
	const handleSellerRank = (e) => {
		if (e.target.checked) {
			setSellerRank(e.target.value);
      setChecked(e.target.value)
		} else setSellerRank('');
	};

  const handleLanguage = (e) => {
		if (e.target.checked) {
			setLanguage(e.target.value);
      setCheckedLang(e.target.value)
		} else setLanguage('');
	};

	return (
		<div>
			<Button variant="outline-primary" className="m-2" onClick={() => handleShow()}>
				<FontAwesomeIcon icon={faFilter} /> Filtrar
			</Button>

			<Modal className="modal" show={show} fullscreen={fullscreen} onHide={() => setShow(false)}>
				<Modal.Header>
					<Modal.Title>Filtrar por</Modal.Title>
				</Modal.Header>
				<Modal.Body>
					<Form className="m-2">
						<Form.Group className="m-2" controlId="formPriceLow">
							<Form.Label>Precio mínimo</Form.Label>
							<Form.Control type="num" placeholder={min + '€'} onChange={handlePrice('min')} />
						</Form.Group>

						<Form.Group className="m-2" controlId="formPriceHigh">
							<Form.Label>Precio máximo</Form.Label>
							<Form.Control type="num" placeholder={max + '€'} onChange={handlePrice('max')} />
						</Form.Group>
						<Form.Group className="m-2" controlId="formSellerRank">
							<Form.Label>Tipo de vendedor</Form.Label>
							<Form.Check
								className="mt-2"
								onChange={handleSellerRank}
								defaultChecked={checked === ''}
								name="groupOptions"
								type="radio"
								label="Todos"
								id="todos"
								value=""
							/>
							<Form.Check
								className="mt-2"
								onChange={handleSellerRank}
                defaultChecked={checked === 'particular'}
								name="groupOptions"
								type="radio"
								label="Particular"
								id="particular"
								value="particular"
							/>
							<Form.Check
								className="mt-2"
								onChange={handleSellerRank}
                defaultChecked={checked === 'empresa'}
								name="groupOptions"
								type="radio"
								label="Empresa"
								id="empresa"
								value="empresa"
							/>
						</Form.Group>
            <Form.Group className="m-2" controlId="formLanguage">
							<Form.Label>Idioma del vendedor</Form.Label>
							<Form.Check
								className="mt-2"
								onChange={handleLanguage}
								defaultChecked={checkedLang === ''}
								name="languageOptions"
								type="radio"
								label="Todos"
								id="todos"
								value=""
							/>
							<Form.Check
								className="mt-2"
								onChange={handleLanguage}
                defaultChecked={checkedLang === 'español'}
								name="languageOptions"
								type="radio"
								label="Español"
								id="español"
								value="español"
							/>
							<Form.Check
								className="mt-2"
								onChange={handleLanguage}
                defaultChecked={checkedLang === 'ingles'}
								name="languageOptions"
								type="radio"
								label="Inglés"
								id="ingles"
								value="ingles"
							/>
							<Form.Check
								className="mt-2"
								onChange={handleLanguage}
                defaultChecked={checkedLang === 'aleman'}
								name="languageOptions"
								type="radio"
								label="Alemán"
								id="aleman"
								value="aleman"
							/>
						</Form.Group>
						<Form.Group className="m-2" controlId="formCountry">
							<Form.Label>País</Form.Label>
							<Form.Select defaultValue={country} aria-label="país" onChange={handleCountry}>
								<option value="todos">Todos</option>
								<option value="españa">España</option>
								<option value="estadosunidos">Estados Unidos</option>
								<option value="cuba">Cuba</option>
								<option value="alemania">Alemania</option>
								<option value="reinounido">Reino Unido</option>
							</Form.Select>
						</Form.Group>
					</Form>
				</Modal.Body>
				<Modal.Footer>
					<Button style={{ width: '100%' }} className='m-2' onClick={handleClose}>
						Filtrar
					</Button>
				</Modal.Footer>
			</Modal>
		</div>
	);
};

export default FilterModal;
