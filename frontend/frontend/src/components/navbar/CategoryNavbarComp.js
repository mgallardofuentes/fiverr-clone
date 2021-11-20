import { Button, ButtonGroup } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { useParams} from 'react-router-dom';
import { useRef, useState  } from 'react';
const CategoryNavbarComp = ({ categories, home }) => {
	const {currentCategory} = useParams()
	const container = useRef();
	let btn;
	const scroll = (scrollOffset) => {
			btn = container.current.scrollLeft += scrollOffset;
	  };

	
	return (
		<div className="categoriesContainer" >
		<div className="scrollButton m-3" style={{ color: home ?  'white' : 'black' }}  onClick={() => scroll(-100)}>{'<'}</div>
		<ButtonGroup ref={container} className="categories-list" style={{ display: 'flex' }} aria-label="Basic example">
		
			{categories.map((category) => {
				if (category.id !== parseInt(currentCategory) ) {
					return (
						<Button
							style={{ borderRadius: '0.25rem' }}
							className="m-3 fullWidth"
							variant="primary"
							key={category.id}
							as={Link}
							to={'/categorias/' + category.id}
						>
							{category.nombre}
						</Button>
						
					);
				}
				else return null
			})}
		</ButtonGroup>
		<div className="scrollButton m-3" style={{ color: home ?  'white' : 'black' }} onClick={() => scroll(100)}>{'>'}</div>
		</div>
	);
};

export default CategoryNavbarComp;
