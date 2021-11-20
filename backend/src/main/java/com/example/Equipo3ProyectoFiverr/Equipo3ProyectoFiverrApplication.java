package com.example.Equipo3ProyectoFiverr;

import com.example.Equipo3ProyectoFiverr.entities.*;
import com.example.Equipo3ProyectoFiverr.repositories.*;
import com.example.Equipo3ProyectoFiverr.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class Equipo3ProyectoFiverrApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Equipo3ProyectoFiverrApplication.class, args);
		CategoriasRepository categoriasRepository = context.getBean(CategoriasRepository.class);
		EmpleadoresRepository empleadoresRepository = context.getBean(EmpleadoresRepository.class);
		OpinionesRepository opinionesRepository = context.getBean(OpinionesRepository.class);
		TrabajosRepository trabajosRepository = context.getBean(TrabajosRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);
		RoleRepository roleRepository = context.getBean(RoleRepository.class);

		LocalDate fecha1 = LocalDate.of(2020, Calendar.DECEMBER, 23);
		LocalDate fecha2 = LocalDate.of(2021, Calendar.FEBRUARY, 7);
		LocalDate fecha3 = LocalDate.of(2021, Calendar.MARCH, 28);
		LocalDate fecha4 = LocalDate.of(2020, Calendar.JULY, 1);
		LocalDate fecha5 = LocalDate.of(2021, Calendar.OCTOBER, 19);
		LocalDate fecha6 = LocalDate.of(2021, Calendar.AUGUST, 22);



		Categorias categoria1 = new Categorias(null,"Desarrollo Software",
				"Sirve para desarrollar Software" );
		Categorias categoria2 = new Categorias(null,"Diseño Sitios Web",
				"Sirve para diseñar sitios" );
		Categorias categoria3 = new Categorias(null,"Diseño Interiores",
				"Sirve para diseñar hogares" );
		Categorias categoria4 = new Categorias(null,"Diseño Exteriores",
				"Sirve para diseñar terrazas" );
		Categorias disenoWeb = new Categorias(null,"Diseño UI/UX",
				"En esta categoría podrás encontrar ofertas relacionadas con el diseño de páginas web." );
		Categorias deAplicacionesMultiplataforma = new Categorias(null,"Desarrollo de aplicaciones multiplataforma",
				"En esta categoría podrás encontrar ofertas relacionadas con el desarrollo de aplicaciones multiplataforma" );
		Categorias desarrolloDeAplicacionesWeb = new Categorias(null,"Desarrollo de aplicaciones web",
				"En esta categoría podrás encontrar ofertas relacionadas con el desarrollo de aplicaciones web");
		Categorias seo = new Categorias(null,"SEO",
				"En esta categoría podrás encontrar ofertas relacionadas con el SEO" );
		Categorias marketingDigital = new Categorias(null, "Marketing Digital",
				"En esta categoría podrás encontrar ofertas relacionadas con el Marketing Digital");
		Categorias animacion3d = new Categorias(null, "Animación 3D",
				"En esta categoría podrás encontrar ofertas relacionadas con la animación 3D");
		Categorias disenoGrafico = new Categorias(null, "Diseño Gráfico",
				"En esta categoría podrás encontrar ofertas relacionadas con el diseño gráfico");

		//Se guardan los objetos de categoría como una lista
		categoriasRepository.saveAll(Arrays.asList(disenoWeb,deAplicacionesMultiplataforma,
				desarrolloDeAplicacionesWeb, seo, marketingDigital));

		categoriasRepository.saveAll(Arrays.asList(categoria1,categoria2,categoria3,categoria4));


		Empleadores empleador1 = new Empleadores(null,"EmpDis","Empresa de Diseño",
				TipoEmpresa.Particular,Paises.España);
		Empleadores empleador2= new Empleadores(null,"EmpSof","Empresa de Software",
				TipoEmpresa.Particular,Paises.España);
		empleador2.setImage("https://source.unsplash.com/featured/?design/600x300/4150");
		empleador1.setImage("https://source.unsplash.com/featured/?design/600x300/4151");

		empleadoresRepository.saveAll(Arrays.asList(empleador1,empleador2));

		Empleadores usuario1 = new Empleadores(null,"markuiux","Daré la primera impresion de tu empresa a nivel web. " +
				"Qué servicios te puedo Ofrecer: " + "\n" +
				"- SEO y SEO Local\n" +
				"- Diseño Web UI y UX.\n" +
				"- Asesoría web\n" +
				"- CTA efectivos en Ecommerce y landing page.\n" +
				"- Estudio del mercado",
				TipoEmpresa.Particular,Paises.España);
		Empleadores usuario2= new Empleadores(null,"devparrot","Soy informático desde los 17 años " +
				"me gradué de técnico medio y " +
				"superior en el área de informática en el ámbito ingeniero, " +
				"domino las herramientas requerida para diseñar " +
				"una pagina web, HTML, PHP, JQUERY, CSS, BOOTSTRAP y BASE DE DATOS.",
				TipoEmpresa.Particular,Paises.España);
		Empleadores usuario3= new Empleadores(null,"designer_francis","Hola, soy Francis, " +
				"el futuro diseñador de tu página web. " +
				"Estoy casi seguro de que puedo ayudarte a conseguir la web que estás buscando.",
				TipoEmpresa.Particular,Paises.España);
		Empleadores usuario4= new Empleadores(null,"animator3d",
				"Especializado en crear personajes y darles vida con habilidades de animación 2D y 3D, " +
						"utilizando software como Krita, Adobe After Effects, Autodesk 3ds max, Autodesk Maya, " +
						"Adobe Premiere, Adobe Photoshop...",
				TipoEmpresa.Particular,Paises.España);
		Empleadores usuario5= new Empleadores(null,"seolover33","Entusiasta de los Negocios y " +
				"del Marketing, con mucha experiencia en el mundo digital, " +
				"Con muchos deseos de seguir creciendo en este mundo digital" +
				"tan interesante.",
				TipoEmpresa.Particular,Paises.España);
		Empleadores usuario6= new Empleadores(null,"wordpress_lopeta","Desarrollador de paginas web en wordpress, " +
				"HTML5,CSS,JS Instalación de plugins, temas,optimización seo, y " +
				"mantenimientos de los sitios! Con mas de 3 años de experiencia en wordpress!",
				TipoEmpresa.Particular,Paises.España);
		Empleadores usuario7= new Empleadores(null,"GonzaloStudio","¡HOLA! Somos una Startup española de diseño y desarrollo de aplicaciones y webs. " +
				"¿A qué esperas para contratarnos?",
				TipoEmpresa.Empresa,Paises.España);
		Empleadores usuario8= new Empleadores(null,"marketing_queen","Especialista en Tecnologías de la Información con experiencia en administración " +
				"de sucursales, ventas Retail, Managment de publicidad multimedia en base " +
				"	a negocios propios y atención al cliente.",
				TipoEmpresa.Particular,Paises.España);
		Empleadores usuario9= new Empleadores(null,"wixpro_paquito","Somos un “Laboratorio Tecnológico” " +
				"de Comunicación Estratégica, Creatividad + tecnología e innovación." +
				"Estamos en constante cambio, siempre actualizados en nuevas tendencias y desarrollos.",
				TipoEmpresa.Empresa,Paises.España);
		Empleadores usuario10= new Empleadores(null,"yayadesign","Soy una abuela de 72 años que ha aprendido programación en un curso del IMSERSO. " +
				"Diseñaré el logo de tu empresa con las últimas tecnologías (Gimp, Paint).",
				TipoEmpresa.Particular,Paises.España);


		usuario1.setImage("https://source.unsplash.com/featured/?smile/600x300/4153");
		usuario2.setImage("https://source.unsplash.com/featured/?smile/600x300/4154");
		usuario3.setImage("https://source.unsplash.com/featured/?smile/600x300/4155");
		usuario4.setImage("https://source.unsplash.com/featured/?smile/600x300/4156");
		usuario5.setImage("https://source.unsplash.com/featured/?smile/600x300/4157");
		usuario6.setImage("https://source.unsplash.com/featured/?smile/600x300/4158");
		usuario7.setImage("https://source.unsplash.com/featured/?smile/600x300/4159");
		usuario8.setImage("https://source.unsplash.com/featured/?smile/600x300/4160");
		usuario9.setImage("https://source.unsplash.com/featured/?smile/600x300/4161");
		usuario10.setImage("https://source.unsplash.com/featured/?smile/600x300/4162");

		//11 Marketing Digital
		Empleadores usuario11 = new Empleadores(null, "marketking", "Hi I'm marketking, a consultant " +
				"helping entrepreneurs scale their businesses with digital products and online courses.", TipoEmpresa.Particular, Paises.EstadosUnidos);

		//12 Marketing Digital
		Empleadores usuario12 = new Empleadores(null, "sensationalbusiness", "Looking for new strategies to grow your Business?Are you fed up with these periods of Favour " +
				"and Famine that follow you throughout the year? Do you dream of reaching 7- or 8-Figures?", TipoEmpresa.Particular, Paises.EstadosUnidos);

		//13
		Empleadores usuario13 = new Empleadores(null, "americanlegend", "I am an individual who Believes in Hard and Accurate Work. " +
				"My main motive is to work Accurately, Efficiently and Professionally. ", TipoEmpresa.Particular, Paises.EstadosUnidos);
		//14 SEO

		Empleadores usuario14= new Empleadores(null, "obSEOssed", "I have more then 6+ years experience of SEO. " +
				"I can provide all kinds of SEO services which will help to get huge traffic", TipoEmpresa.Empresa, Paises.EstadosUnidos);
		//15

		Empleadores usuario15= new Empleadores(null, "marketeggs", "I just love market and eggs, man!", TipoEmpresa.Particular, Paises.ReinoUnido);
		//16 SEO

		Empleadores usuario16= new Empleadores(null, "benedictSEO", " We're an online marketing agency which specializes in Search Engine Optimization", TipoEmpresa.Empresa, Paises.ReinoUnido);
		//17 SEO

		Empleadores usuario17= new Empleadores(null, "immortalUK22", "I have been in the SEO industries for over " +
				"9 years I have ranked many websites in my SEO Career,", TipoEmpresa.Particular, Paises.ReinoUnido);

		//18 SEO
		Empleadores usuario18= new Empleadores(null, "seodeutch", "Verschaffen Sie sich einen Vorsprung vor Ihrer Konkurrenz mit meinen SEO-, Website-Analyse-, " +
				"Website-Promotion- und anderen Dienstleistungen. Ich bin ein britischer Verkäufer, der in Frankreich lebt.", TipoEmpresa.Particular, Paises.Alemania);

		//19 Marketing Digital
		Empleadores usuario19= new Empleadores(null, "marketverkauft", "Hallo, ich bin marketverkauft. Wir bieten unseren Kunden die " +
				"strategische Unterstützung, die sie für ein florierendes Unternehmen benötigen.", TipoEmpresa.Empresa, Paises.Alemania);

		//20 SEO
		Empleadores usuario20= new Empleadores(null, "elisss33", "Ich habe mehr als 100+ Zufriedene Kunden, " +
				"Sie erhalten eine gute Anzahl von Verkäufen und Verkehr von meinem besten SEO-Service. ", TipoEmpresa.Empresa, Paises.Alemania);



		usuario11.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		usuario12.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		usuario13.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		usuario14.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		usuario15.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		usuario16.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		usuario17.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		usuario18.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		usuario19.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		usuario20.setImage("https://source.unsplash.com/featured/?smile/600x300/1");


		//Se guardan los ojbetos de usuario como una lista
		empleadoresRepository.saveAll(Arrays.asList(usuario11, usuario12, usuario13, usuario14,
				usuario15, usuario16, usuario17, usuario18, usuario19, usuario20));


		//Se guardan los ojbetos de usuario como una lista
		empleadoresRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3, usuario4,
				usuario5, usuario6, usuario7, usuario8, usuario9, usuario10));


		Trabajos trabajo21 = new Trabajos(null,"Desarrollar API", "",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);
		trabajo21.setFecha(fecha2);
		Trabajos trabajo22 = new Trabajos(null,"Desarrollar API", "",
				425.2,Boolean.TRUE,Paises.EstadosUnidos,Idiomas.Ingles);
		trabajo22.setFecha(fecha3);
		Trabajos trabajo23 = new Trabajos(null,"Diseñar terraza","",
				2000d,Boolean.FALSE,Paises.EstadosUnidos,Idiomas.Ingles);
		trabajo23.setFecha(fecha4);



		List<Categorias> categorias1 = Arrays.asList(categoria1,categoria2);
		List<Categorias> categorias2 = Arrays.asList(categoria3,categoria4);

		for (Categorias categoria : categorias1) {
			trabajo21.addCategoria(categoria);

		}
		for (Categorias categoria : categorias2) {
			trabajo23.addCategoria(categoria);

		}
		trabajo22.addCategoria(categoria1);

		trabajo21.addEmpleador(empleador2);
		trabajo22.addEmpleador(empleador1);
		trabajo21.setImage("https://source.unsplash.com/featured/?design/600x300/4181");
		trabajo22.setImage("https://source.unsplash.com/featured/?design/600x300/4182");
		trabajo23.setImage("https://source.unsplash.com/featured/?design/600x300/4183");

		Trabajos trabajo1 = new Trabajos(null,"Diseñaré la identidad visual de tu negocio.", "El Por qué deberíamos de trabajar juntos:\n" +

				"Mi objetivo es hacer una página efectiva para conectar con el cliente " +
				"y asi generar ventas, aplico neurociencias, psicologia del consumidor y marketing digital, ",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);

		Trabajos trabajo2 = new Trabajos(null,"Haré todo tipo de diseño, de páginas web a tu medida.", "Hacemos todo tipo de paginas web a tu medida, con las herramientas " +
				"mas puras que es html, css, jquery, javascript, php, mysql y entre otros",
				425.2,Boolean.TRUE,Paises.EstadosUnidos,Idiomas.Ingles);

		Trabajos trabajo3 = new Trabajos(null,"Haré una página web escalable y segura","Diseño una página web " +
				"totalmente funcional.\n" +
				"\n" +
				"Todas las páginas web que diseño son bonitas, seguras y escalables.\n" +
				"\n" +

				"Realizo un auditoria de seguridad y velocidad para entregar un proyecto que funcione bien desde el primer día.",
				200.4,Boolean.FALSE,Paises.EstadosUnidos,Idiomas.Ingles);

		Trabajos trabajo4 = new Trabajos(null,"Haré una animación en 2d, 3D, animación de personajes, " +
				"animación 3D", "Hola mi nombre es ANIMATOR3D y esta es mi marca LPX." +
				" Soy un artista 3D profesional de Colombia con más de 10 años de experiencia en la industria del 3D y " +
				"los videojuegos.",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);

		Trabajos trabajo5 = new Trabajos(null,"Seré tu experto en email marketing, getresponse " +
				"y diseño web", "Entusiasta de los negocios y el marketing, con mucha experiencia en el mundo " +
				"digital. ",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);

		Trabajos trabajo6 = new Trabajos(null,"Te instalaré WordPress con tu tema de elección " +
				"en una hora.", "Instalo tu WordPress y tema de preferencia en 1Hora. Te proporciono:\n" +
				"\n" +
				"Configuración como demo\n" +
				"\n" +
				"¿Qué necesito antes de empezar?\n" +
				"Acceso a WP Login\n",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);

		Trabajos trabajo7 = new Trabajos(null,"Desarrollaremos tu aplicación multiplataforma", "El precio de la app multiplataforma no es 5$" +
				", esto depende de lo " +
				"que necesites, por eso primero tenemos que ver qué funciones quieres y necesitas en tu " +
				"aplicación para darte un precio totalmente a medida",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);

		Trabajos trabajo8 = new Trabajos(null,"Crearemos el contenido multimedia para tu página web", "Creacion de contenido " +
				"multimedia como banners, tripticos, logotipos, posters, asi como desarrollo de paginas web,",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);

		Trabajos trabajo9 = new Trabajos(null,"Diseñaré tu folleto, revista o libro", "Mis servicios incluyen:\n" +
				"\n" +
				"Revistas y Suplementos físicos y web\n" +
				"Libro de diseño de interiores\n" +
				"Diseño de la portada del libro\n" +
				"Entrega en formato pdf para web\n",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);

		Trabajos trabajo10 = new Trabajos(null,"Diseñaré tu identidad empresarial", "¿Buscas algo único, creativo, " +
				"llamativo, muy profesional y con un diseño limpio? Has dado con la oferta adecuada para tu trabajo " +
				"de diseño gráfico.\n" +
				"\n" +
				"Puedo aportar ideas creativas basadas en los requisitos especiales de mis clientes.",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);





		trabajo1.setFecha(fecha1);
		trabajo2.setFecha(fecha2);
		trabajo3.setFecha(fecha3);
		trabajo4.setFecha(fecha3);
		trabajo5.setFecha(fecha4);
		trabajo6.setFecha(fecha1);
		trabajo7.setFecha(fecha4);
		trabajo8.setFecha(fecha4);
		trabajo9.setFecha(fecha4);
		trabajo10.setFecha(fecha4);



		trabajo1.addEmpleador(usuario1);
		trabajo2.addEmpleador(usuario2);
		trabajo3.addEmpleador(usuario3);
		trabajo4.addEmpleador(usuario4);
		trabajo5.addEmpleador(usuario5);
		trabajo6.addEmpleador(usuario6);
		trabajo7.addEmpleador(usuario7);
		trabajo8.addEmpleador(usuario8);
		trabajo9.addEmpleador(usuario9);
		trabajo10.addEmpleador(usuario10);



		trabajo1.setImage("https://source.unsplash.com/featured/?web/600x300/4191");
		trabajo2.setImage("https://source.unsplash.com/featured/?web/600x300/4192");
		trabajo3.setImage("https://source.unsplash.com/featured/?web/600x300/4193");
		trabajo4.setImage("https://source.unsplash.com/featured/?web/600x300/4194");
		trabajo5.setImage("https://source.unsplash.com/featured/?web/600x300/4195");
		trabajo6.setImage("https://source.unsplash.com/featured/?web/600x300/4196");
		trabajo7.setImage("https://source.unsplash.com/featured/?web/600x300/4197");
		trabajo8.setImage("https://source.unsplash.com/featured/?web/600x300/4198");
		trabajo9.setImage("https://source.unsplash.com/featured/?web/600x300/4199");
		trabajo10.setImage("https://source.unsplash.com/featured/?web/600x300/4200");


		trabajo1.addCategoria(disenoWeb);
		trabajo2.addCategoria(desarrolloDeAplicacionesWeb);
		trabajo3.addCategoria(desarrolloDeAplicacionesWeb);
		trabajo4.addCategoria(disenoWeb);
		trabajo5.addCategoria(disenoWeb);
		trabajo6.addCategoria(desarrolloDeAplicacionesWeb);
		trabajo7.addCategoria(deAplicacionesMultiplataforma);
		trabajo8.addCategoria(disenoWeb);
		trabajo9.addCategoria(disenoWeb);
		trabajo10.addCategoria(disenoWeb);


		//guardamos las entidades en el repositorio


		trabajosRepository.save(trabajo1);
		trabajosRepository.save(trabajo2);
		trabajosRepository.save(trabajo3);
		trabajosRepository.save(trabajo4);
		trabajosRepository.save(trabajo5);
		trabajosRepository.save(trabajo6);
		trabajosRepository.save(trabajo7);
		trabajosRepository.save(trabajo8);
		trabajosRepository.save(trabajo9);
		trabajosRepository.save(trabajo10);
		trabajosRepository.save(trabajo21);
		trabajosRepository.save(trabajo22);


		Trabajos trabajo11 = new Trabajos(null, "I will scale your business " +
				"with digital products", "When people search your name on a search engine (Google) then will show an Information " +
				"Box in Google Top right site. This Information Box is Google Knowledge Panel.",
				34.99, Boolean.TRUE, Paises.EstadosUnidos, Idiomas.Ingles);
		Trabajos trabajo12 = new Trabajos(null, "I will make you reach 7 " +
				"figures", "Whether it is an e-commerce organization or an average " +
				"brick-and-mortar trade, if you want to maximize your success, " +
				"you ought to be proficient in how to successfully market your business on the internet.",
				29.99, Boolean.TRUE, Paises.EstadosUnidos, Idiomas.Ingles);
		Trabajos trabajo13 = new Trabajos(null, "I will make your business " +
				"skyrocket", "I can help you to boost your productivity, social media presence and improve the quality of your marketing results. You should harness " +
				"the power of virtual assistants by integrating them into your marketing strategy. ",
				15.99, Boolean.TRUE, Paises.EstadosUnidos, Idiomas.Ingles);
		Trabajos trabajo14 = new Trabajos(null, "I will provide you the best " +
				"SEO services", "The posts will be listed on the homepage of " +
				"our site for a limited time until new posts are published.",
				49.99, Boolean.TRUE, Paises.EstadosUnidos, Idiomas.Ingles);
		Trabajos trabajo15 = new Trabajos(null, "I will optimize your searches " +
				"on the Internet", "This will help your website gain trust & authority and traction " +
				"with the search engines to rank higher in the search results.",
				44.00, Boolean.TRUE, Paises.ReinoUnido, Idiomas.Ingles);
		Trabajos trabajo16 = new Trabajos(null, "I will make your website " +
				"reach a top tier", "You will improve your website according to search engine terms " +
				"and conditions by taking our special “on-page optimization” package.n",
				69.99, Boolean.TRUE, Paises.ReinoUnido, Idiomas.Ingles);
		Trabajos trabajo17 = new Trabajos(null, "I will make your website " +
				"be successfull", "In my standard & premium packs, I will include one week of on-site S.E.O," +
				" implementing changes & fixes necessary (10 pages) to help you rank higher. ",
				34.99, Boolean.TRUE, Paises.ReinoUnido, Idiomas.Ingles);
		Trabajos trabajo18 = new Trabajos(null, "Ich werde Ihre Website zur " +
				"meistgesuchten Website machen", "Es gibt über 200 SEO-Faktoren und Backlinks sind einer " +
				"der wichtigsten Faktoren der Offpage-SEO. Backlinks geben Signale an Google.",
				19.99, Boolean.TRUE, Paises.Alemania, Idiomas.Alemán);
		Trabajos trabajo19 = new Trabajos(null, "Ich werde dafür sorgen, dass Ihr " +
				"Unternehmen seine Gewinne steigert", "Sie erhalten 100% operative " +
				"E-Commerce-Website / Shop mit sicheren pyament Gateway. " +
				"Auch erhalten Sie voll funktionsfähige Dashboard, wo Sie Inventar/Produkte " +
				"verwalten können und verfolgen Bestellungen und Zahlungen.n",
				150.00, Boolean.TRUE, Paises.Alemania, Idiomas.Alemán);
		Trabajos trabajo20 = new Trabajos(null, "Ich werde Ihr SEO erstaunlich machen", "Wenn Sie Ihre Website auf der ersten Seite von Google platzieren möchten," +
				" um mehr Umsatz und Traffic zu erhalten, dann sind Sie hier genau richtig. ",
				33.44, Boolean.TRUE, Paises.Alemania, Idiomas.Alemán);

		;



		trabajo11.setFecha(fecha1);
		trabajo12.setFecha(fecha2);
		trabajo13.setFecha(fecha3);
		trabajo14.setFecha(fecha3);
		trabajo15.setFecha(fecha4);
		trabajo16.setFecha(fecha1);
		trabajo17.setFecha(fecha4);
		trabajo18.setFecha(fecha4);
		trabajo19.setFecha(fecha4);
		trabajo20.setFecha(fecha4);


		trabajo11.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		trabajo12.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		trabajo13.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		trabajo14.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		trabajo15.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		trabajo16.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		trabajo17.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		trabajo18.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		trabajo19.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		trabajo20.setImage("https://source.unsplash.com/featured/?web/600x300/1");



		trabajo11.addEmpleador(usuario11);
		trabajo12.addEmpleador(usuario12);
		trabajo13.addEmpleador(usuario13);
		trabajo14.addEmpleador(usuario14);
		trabajo15.addEmpleador(usuario15);
		trabajo16.addEmpleador(usuario16);
		trabajo17.addEmpleador(usuario17);
		trabajo18.addEmpleador(usuario18);
		trabajo19.addEmpleador(usuario19);
		trabajo20.addEmpleador(usuario20);



		trabajo11.addCategoria(marketingDigital);
		trabajo12.addCategoria(marketingDigital);
		trabajo13.addCategoria(marketingDigital);
		trabajo14.addCategoria(seo);
		trabajo15.addCategoria(marketingDigital);
		trabajo16.addCategoria(seo);
		trabajo17.addCategoria(seo);
		trabajo18.addCategoria(seo);
		trabajo19.addCategoria(marketingDigital);
		trabajo20.addCategoria(seo);

		//guardamos las entidades en el repositorio


		trabajosRepository.save(trabajo11);
		trabajosRepository.save(trabajo12);
		trabajosRepository.save(trabajo13);
		trabajosRepository.save(trabajo14);
		trabajosRepository.save(trabajo15);
		trabajosRepository.save(trabajo16);
		trabajosRepository.save(trabajo17);
		trabajosRepository.save(trabajo18);
		trabajosRepository.save(trabajo19);
		trabajosRepository.save(trabajo20);



		Opiniones opinion1 = new Opiniones(null,4,"esta mas o menos",trabajo1,empleador2);
		Opiniones opinion2 = new Opiniones(null,5,"esta muy bien",trabajo1,empleador2);
		Opiniones opinion3 = new Opiniones(null,4,"esta por ahi",trabajo1,empleador2);
		Opiniones opinion4 = new Opiniones(null,4,"esta  bien",trabajo1,empleador2);
		Opiniones opinion5 = new Opiniones(null,5,"esta muy bien",trabajo2,empleador2);
		Opiniones opinion6 = new Opiniones(null,4,"esta muy bien",trabajo2,empleador2);
		Opiniones opinion7 = new Opiniones(null,4,"esta  bien",trabajo3,empleador1);
		opinionesRepository.saveAll(Arrays.asList(opinion1,opinion2,opinion3,opinion4,opinion5,opinion6,opinion7));

		Opiniones o1 = new Opiniones(null,4,"Una web increíble. Justo lo que necesitaba. Volveré a repetir sin duda.\n" +
				"\n",trabajo1,usuario2);
		Opiniones o2 = new Opiniones(null,4,"Un gusto trabajar con " + usuario1.getNombre() + " " +
				"desde el minuto uno me inspiró mucha confianza para la realización de este proyecto.",trabajo1,usuario3);
		Opiniones o3 = new Opiniones(null,4,"todo de lujo, trabajo y comunicación fluida.\n" +
				"\n",trabajo1,usuario4);
		opinionesRepository.saveAll(Arrays.asList(o1, o2, o3));
		//Opiniones trabajo 2
		Opiniones o4= new Opiniones(null,5,"Un servicio espectacular.",trabajo2,usuario1);
		Opiniones o5= new Opiniones(null,5,"sin duda repetiré la experiencia",trabajo2,usuario3);
		Opiniones o6= new Opiniones(null,5,"Muy buena respuesta como siempre, el diseño supero lo esperado y muy buena retroalimentación con las revisiones",trabajo2,usuario4);
		opinionesRepository.saveAll(Arrays.asList(o4, o5, o6));
		//Opiniones trabajo 3
		Opiniones o7 = new Opiniones(null,4,"Todo en orden, tuvimos muchas revisiones, siempre respondio bien\n" +
				"\n",trabajo3,usuario2);
		Opiniones o8 = new Opiniones(null,4,"Espectacular persona y profesional. " +
				"He tenido un problema y un montón de dudas durante este proceso de crear una página web " +
				"y el me ha resuelto el problema.",trabajo3,usuario5);
		Opiniones o9 = new Opiniones(null,4,"Me gusto mucho trabajar con el, muy buena la comunicación y entendió a la perfección lo que quería, además mejoro muchas cosas de la pagina. Lo recomiendo al 1000%\n" +
				"\n",trabajo3,usuario6);
		opinionesRepository.saveAll(Arrays.asList(o7, o8, o9));
		//Opiniones trabajo 4
		Opiniones o10 = new Opiniones(null,4,"Muy Buen trabajo! Se ajusta a lo que necesitas, buena comunicación\n" +
				"\n",trabajo4,usuario6);
		Opiniones o11 = new Opiniones(null,4,"Es un placer trabajar siempre con" + usuario4.getNombre() + ", trabaja muy rápido y la comunicación es más constante.\n" +
				"\n",trabajo4,usuario7);
		Opiniones o12 = new Opiniones(null,4,"fue estupendo, una persona que transmite confianza, seguridad en su trabajo y experto en lo que hace. Muchas gracias Jesús por tu trabajo.",trabajo4,usuario8);
		opinionesRepository.saveAll(Arrays.asList(o10, o11, o12));
		//Opiniones trabajo 5
		Opiniones o13 = new Opiniones(null,5,"awesome job! I'm so pleased!\n" +
				"\n",trabajo6,usuario1);
		Opiniones o14 = new Opiniones(null,5,"Great customer service. Fast communication. Really happy with turn around time and quality of work. Will definitely use Saad again.\n" +
				"\n",trabajo6,usuario2);
		Opiniones o15 = new Opiniones(null,5,"Super rapido y un diseño que me encanto.\n" +
				"\n",trabajo6,usuario3);
		opinionesRepository.saveAll(Arrays.asList(o13, o14, o15));
		//Opiniones trabajo 6
		Opiniones o16 = new Opiniones(null,4,"perfecto",trabajo7,usuario4);
		Opiniones o17 = new Opiniones(null,4,"Great work on a relatively simple project for someone who has obvious great design skill! Pleased with the outcome and does the job.\n" +
				"\n",trabajo7,usuario5);
		Opiniones o18 = new Opiniones(null,4,"Wonderful graphic design and color. Excellent communication with seller and provided service as described and would definitely recommend. Thank you so much.",trabajo7,usuario6);
		opinionesRepository.saveAll(Arrays.asList(o16, o17, o18));
		//Opiniones trabajo 7
		Opiniones o19 = new Opiniones(null,4,"So nice working with someone who does their job well. Really a lot less stress and headache when someone 'understands the assignment'. Great job.",trabajo7,usuario7);
		Opiniones o20 = new Opiniones(null,4,"the only negative is that you couldn't email the files to me which doesn't really make any sense. it made it harder for me to get the I do to the stencil manufacturer.",trabajo7,usuario8);
		Opiniones o21 = new Opiniones(null,4,"Atento, servicial, competente, un trabajo impecable. Lo seguiré teniendo en cuenta para futuros proyectos. Attentive, helpful, competent, impeccable work. I will keep him in mind for future projects.\n" +
				"\n",trabajo7,usuario9);
		opinionesRepository.saveAll(Arrays.asList(o19, o20, o21));
		//Opiniones trabajo 8
		Opiniones o22 = new Opiniones(null,4,"Very great worker! it´s a really fantastic word and very good comunicated\n" +
				"\n",trabajo8,usuario10);
		Opiniones o23 = new Opiniones(null,4,"Muy atento y paciente con los requerimientos!\n" +
				"\n",trabajo8,usuario1);
		Opiniones o24 = new Opiniones(null,4,"Best experience",trabajo8,usuario5);
		opinionesRepository.saveAll(Arrays.asList(o22, o23, o24));
		//Opiniones trabajo 9
		Opiniones o25 = new Opiniones(null,4,"MUY PROFESIONAL",trabajo9,usuario8);
		Opiniones o26 = new Opiniones(null,4,"excelente trabajo,muy receptivo y siempre dispuesto a ayudarte",trabajo9,usuario4);
		Opiniones o27 = new Opiniones(null,4,"fast response great comunication will do it again anytime I need his services\n" +
				"\n",trabajo9,usuario5);
		opinionesRepository.saveAll(Arrays.asList(o25, o26, o27));
		//Opiniones trabajo 10
		Opiniones o28 = new Opiniones(null,5,"100% RECOMMENDED! her work was " +
				"impecable 1-communication was excellent, captured our brand aesthetic perfectly! " +
				"she made my website came to life exactly how i wanted it! 2 quality-price exceed my " +
				"expectations",trabajo10,usuario7);
		Opiniones o29 = new Opiniones(null,5,"She did an excellent job, " +
				"beyond my expectations. I can recommend him and I will surely continue working with her.",trabajo10,usuario8);
		Opiniones o30 = new Opiniones(null,5,"Excelente trabajo por parte de la vendedora, " +
				"genera muy buenas propuestas creativas con un alto nivel profesional",trabajo10,usuario2);
		opinionesRepository.saveAll(Arrays.asList(o28, o29, o30));

		Opiniones o31 = new Opiniones(null,5,"Excelente trabajo, increible los resultados obtenidos"
				,trabajo11,usuario4);
		opinionesRepository.save(o31);
		//Opiniones trabajo 11

		Opiniones o32 = new Opiniones(null, 5, "It was nice " +
				"working with you. Thanks for your service!", trabajo11, usuario13);
		Opiniones o33 = new Opiniones(null, 5, "Lovely services. " +
				"Would hire them again! " +
				"\n", trabajo11, usuario14);
		opinionesRepository.saveAll(Arrays.asList(o31, o32, o33));

		//Opiniones trabajo 12

		Opiniones o34 = new Opiniones(null, 5, "The best" +
				" digital marketing services ever!", trabajo12, usuario11);
		Opiniones o35 = new Opiniones(null, 5, "It was nice " +
				"working with you. Thanks for your service!", trabajo12, usuario13);
		Opiniones o36 = new Opiniones(null, 5, "He helepd me " +
				"to grow my business" +
				"\n", trabajo12, usuario14);
		opinionesRepository.saveAll(Arrays.asList(o34, o35, o36));

		//Opiniones trabajo 13

		Opiniones o37 = new Opiniones(null, 5, "Took a " +
				"realistic approach to my problem. Thank you :)", trabajo13, usuario14);
		Opiniones o38 = new Opiniones(null, 5, "My website " +
				"is the first one in the Search Engines", trabajo13, usuario15);
		Opiniones o39 = new Opiniones(null, 5, "Before your " +
				"work, my website wuld not show up on Google. Thank you!", trabajo13, usuario16);
		opinionesRepository.saveAll(Arrays.asList(o37, o38, o39));

		//Opiniones trabajo 14
		Opiniones o40 = new Opiniones(null, 5, "Took a realistic" +
				" approach to my problem. Thank you :)", trabajo14, usuario12);
		//Opiniones trabajo 15
		Opiniones o41 = new Opiniones(null, 5, "My website is " +
				"the first one in the Search Engines", trabajo15, usuario16);
		//Opiniones trabajo 16
		Opiniones o42 = new Opiniones(null, 5, "Before your work, " +
				"my website wuld not show up on Google. Thank you!", trabajo16, usuario17);
		opinionesRepository.saveAll(Arrays.asList(o40, o41, o42));

		//Opiniones trabajo 17
		Opiniones o43 = new Opiniones(null, 5, "Took a " +
				"realistic approach to my problem. Thank you :)", trabajo17, usuario12);
		//Opiniones trabajo 18
		Opiniones o44 = new Opiniones(null, 5, "My website i" +
				"s the first one in the Search Engines", trabajo18, usuario13);
		//Opiniones trabajo 19
		Opiniones o45 = new Opiniones(null, 5, "Before your " +
				"work, my website wuld not show up on Google. Thank you!", trabajo19, usuario14);
		//Opiniones trabajo 20
		Opiniones o46 = new Opiniones(null, 5, "Took a " +
				"realistic approach to my problem. Thank you :)", trabajo20, usuario12);
		opinionesRepository.saveAll(Arrays.asList(o40, o41, o42, o46));

		Role role1 = new Role(1,"ADMIN", "Rol Admin");
		Role role2 = new Role(2,"USER", "Rol User");
		roleRepository.save(role1);
		roleRepository.save(role2);
		User user = new User(1,"admin","$2a$10$DTAejq8zVwf.dMadV1SAvuNXAbXjroY.G7dWpS1tzoGolwn7nexTm","","","","");
		Set<Role> useradmin =new HashSet<>();
		useradmin.add(role1);
		useradmin.add(role2);
		user.setRoles(useradmin);
		userRepository.save(user);




	}



}
