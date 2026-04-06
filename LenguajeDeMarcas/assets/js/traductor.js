/* 
   DICCIONARIO DE TRADUCCIONES 
   Hecho para la web de Happiness & Co
   Soporta Español, Inglés y Francés
*/
const translations = {
    es: {
        nav_inicio: "Inicio",
        nav_eventos: "Eventos",
        nav_calendario: "Calendario",
        nav_asturias: "Asturias",
        hero_title_1: "Cultura",
        hero_title_2: " que emociona",
        hero_desc: "Descubre los mejores eventos de Asturias. Música, teatro, exposiciones y mucho más en un solo lugar.",
        hero_btn: "Explora eventos",
        section_eventos_title: "Todos los eventos",
        section_eventos_desc: "4 eventos disponibles",
        premium_magia: "Vive la magia cultural",
        premium_intro: "Un recorrido visual por los eventos más emocionantes que Asturias tiene para ofrecer",
        stat_festivales: "Festivales",
        stat_conciertos: "Conciertos",
        stat_obras: "Obras",
        stat_exposiciones: "Exposiciones",
        mision_title: "Nuestra Misión",
        mision_text: "Crear una plataforma centralizada donde los amantes de la cultura puedan descubrir, explorar y disfrutar de la rica oferta cultural de nuestra ciudad. Queremos que cada día sea una oportunidad para vivir nuevas experiencias.",
        footer_links: "ENLACES RÁPIDOS",
        footer_social: "SÍGUENOS",
        footer_copyright: "© 2026 HAPPINESS&Co. Todos los derechos reservados. Hecho con ❤️ en Asturias",
        // Páginas secundarias
        title_calendario: "Calendario de eventos",
        desc_calendario: "Consulta las fechas y envíanos tu propuesta de evento",
        title_asturias: "Asturias: Paraíso Cultural",
        desc_asturias: "Explora la belleza y la cultura de nuestra región"
    },
    en: {
        nav_inicio: "Home",
        nav_eventos: "Events",
        nav_calendario: "Calendar",
        nav_asturias: "Asturias",
        hero_title_1: "Culture",
        hero_title_2: " that moves you",
        hero_desc: "Discover the best events in Asturias. Music, theater, exhibitions and much more in one place.",
        hero_btn: "Explore events",
        section_eventos_title: "All Events",
        section_eventos_desc: "4 events available",
        premium_magia: "Live the cultural magic",
        premium_intro: "A visual journey through the most exciting events Asturias has to offer",
        stat_festivales: "Festivals",
        stat_conciertos: "Concerts",
        stat_obras: "Plays",
        stat_exposiciones: "Exhibitions",
        mision_title: "Our Mission",
        mision_text: "To create a centralized platform where culture lovers can discover, explore, and enjoy our city's rich cultural offerings. We want every day to be an opportunity for new experiences.",
        footer_links: "QUICK LINKS",
        footer_social: "FOLLOW US",
        footer_copyright: "© 2026 HAPPINESS&Co. All rights reserved. Made with ❤️ in Asturias",
        // Subpages
        title_calendario: "Event Calendar",
        desc_calendario: "Check dates and send us your event proposal",
        title_asturias: "Asturias: Cultural Paradise",
        desc_asturias: "Explore the beauty and culture of our region"
    },
    fr: {
        nav_inicio: "Accueil",
        nav_eventos: "Événements",
        nav_calendario: "Calendrier",
        nav_asturias: "Asturies",
        hero_title_1: "Culture",
        hero_title_2: " qui vous émeut",
        hero_desc: "Découvrez les meilleurs événements des Asturies. Musique, théâtre, expositions et bien plus encore au même endroit.",
        hero_btn: "Explorer les événements",
        section_eventos_title: "Tous les événements",
        section_eventos_desc: "4 événements disponibles",
        premium_magia: "Vive la magie culturelle",
        premium_intro: "Un voyage visuel à travers les événements les plus excitants que les Asturies ont à offrir",
        stat_festivales: "Festivals",
        stat_conciertos: "Concerts",
        stat_obras: "Pièces",
        stat_exposiciones: "Expositions",
        mision_title: "Notre Mission",
        mision_text: "Créer une plateforme centralisée où los amateurs de culture peuvent découvrir, explorer et profiter de la riche offre culturelle de notre ville. Nous voulons que chaque jour soit une opportunité de vivre de nouvelles expériences.",
        footer_links: "LIENS RAPIDES",
        footer_social: "SUIVEZ-NOUS",
        footer_copyright: "© 2026 HAPPINESS&Co. Tous droits réservés. Fait avec ❤️ en Asturies",
        // Subpages
        title_calendario: "Calendrier des événements",
        desc_calendario: "Consultez les dates et envoyez-nous votre proposition d'événement",
        title_asturias: "Asturies : Paradis Culturel",
        desc_asturias: "Explorez la beauté et la culture de notre région"
    }
};

// Esta función cambia el texto de los elementos que tengan el atributo data-i18n
function cambiarIdioma(idioma) {
    const elementos = document.querySelectorAll("[data-i18n]");
    
    elementos.forEach(el => {
        const clave = el.getAttribute("data-i18n");
        if (translations[idioma] && translations[idioma][clave]) {
            el.textContent = translations[idioma][clave];
        }
    });

    // Cambiamos el placeholder del buscador según el idioma
    const inputBuscar = document.getElementById("buscar");
    if (inputBuscar) {
        if (idioma === 'en') inputBuscar.placeholder = "Search...";
        else if (idioma === 'fr') inputBuscar.placeholder = "Chercher...";
        else inputBuscar.placeholder = "Buscar...";
    }

    // Guardamos el idioma elegido para que no se pierda al recargar
    localStorage.setItem("idioma_preferido", idioma);
    
    // Si hay un selector desplegable, lo actualizamos también para que marque el correcto
    const selector = document.getElementById("language-select");
    if (selector) {
        selector.value = idioma;
    }
}

// Cuando la página se carga del todo
document.addEventListener("DOMContentLoaded", () => {
    // Miramos si ya había un idioma guardado, si no, usamos español
    const idiomaGuardado = localStorage.getItem("idioma_preferido") || "es";
    cambiarIdioma(idiomaGuardado);

    // Escuchamos el cambio en el selector desplegable (select)
    const selector = document.getElementById("language-select");
    if (selector) {
        selector.addEventListener("change", (evento) => {
            const nuevoIdioma = evento.target.value;
            cambiarIdioma(nuevoIdioma);
        });
    }
});
