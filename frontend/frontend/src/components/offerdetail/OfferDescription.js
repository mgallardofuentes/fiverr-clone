const OfferDescription = ({ offer }) => {
	return (
		<div id="description" className="mt-4 offerDescription" style={{ textAlign: 'left' }}>
			<h2>Acerca de esta oferta</h2>
			<p>
				{offer.descripcion ? (
					offer.descripcion
				) : (
					'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Odio officia labore minus magnam repudiandae quibusdam accusamus, impedit eveniet cupiditate doloribus! Ad excepturi tempora reiciendis dolore quod asperiores ut est omnis'
				)}
			</p>
		</div>
	);
};

export default OfferDescription;
