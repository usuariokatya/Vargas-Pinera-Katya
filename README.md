# Mi Proyecto: HAPPINESS&Co

Este es el repositorio donde estaré subiendo todo el proyecto de la agenda cultural HAPPINESS&Co, una web para descubrir eventos culturales de Asturias: música, teatro, cine, arte, festivales y mucho más.

He organizado el proyecto en las carpetas que nos pedían:

- **Lenguaje de marcas:** Las páginas de la web están bastante avanzadas y por ahora se ven como quiero, aunque seguramente cambie cosas más adelante:
  - `index.html` — Página principal con los eventos, un vídeo de Asturias y estadísticas.
  - `eventos.html` — Todos los eventos separados en próximos y finalizados, con filtros por categoría funcionando.
  - `calendario.html` — Calendario que se genera solo con JavaScript, puedes moverte entre meses y proponer eventos desde un formulario.
  - `asturias.html` — Galería de fotos de eventos con vídeo y texto sobre Asturias.
  - `reset.css` — Elimina los estilos que los navegadores aplican por defecto para que la web se vea igual en todos.
  - `global.css` — Estilos base de toda la web (colores, fuentes, reset).
  - `style.css` — Estilos más específicos, todavía en progreso.

- **Base de datos:** Tablas creadas en Oracle SQL Developer (Eventos, Usuarios, Galerías, Imágenes y Favoritos) con datos de prueba, IDs automáticos, constraints y vistas. El diagrama E-R está hecho en Dia y TOAD.

- **Programación:** He añadido JavaScript para el calendario dinámico y los filtros de categoría. La parte de Java está pendiente.

- **RSS:** Archivo XML con los 3 próximos eventos en formato RSS 2.0 (Festival de Verano, Cine bajo las estrellas y Expo Arte Moderno).

## Sobre el diseño

Primero hice el boceto en blanco y negro para planear la estructura, luego lo pasé a color siguiendo la paleta del PDF. Ahora está todo en código.

He seguido los colores del PDF:

- Rosa `#ba007c` para música y logo.
- Azul `#009bdb` para cine y teatro.
- Naranja `#ff7b00` para exposiciones.
- Gris `#555555` para textos.

Los estilos están en `reset.css`, `global.css` y `style.css` junto con Tailwind CSS. La web luce como quiero visualmente, aunque es probable que haga cambios mientras voy revisando cosas.

## Lo que he aprendido

Cosas que no sabía antes y he ido aprendiendo mientras hacía el proyecto:

- **`CREATE VIEW` en Oracle SQL** — Una vista es como guardar una consulta con nombre. En vez de escribir el mismo SELECT largo cada vez, lo guardas como vista y lo usas como si fuera una tabla normal.

- **`SEQUENCE`** — En Oracle no existe AUTO_INCREMENT. Hay que crear una secuencia aparte para que los IDs se generen solos al insertar datos.

- **`ON DELETE CASCADE`** — Si borras un evento, esto hace que se borren automáticamente sus galerías e imágenes asociadas.

- **CSS Grid (`display: grid`)** — Organiza elementos en filas y columnas a la vez, como una cuadrícula. Lo uso en la galería de fotos para que las imágenes se coloquen solas en varias columnas.

- **`tailwind.config`** — La configuración de Tailwind para añadir mis propios colores y usarlos como clases directamente en el HTML.

- **`data-categoria="musica"`** — Un atributo personalizado que le puse a los botones de filtro. JavaScript lo lee para saber qué categoría pulsó el usuario y mostrar solo esos eventos.

- **`new Date()` y `.getMonth()`** — Funciones de JavaScript para trabajar con fechas en el calendario. Dato: en JavaScript enero es el mes 0, no el 1.

- **RSS 2.0 en vez de 1.0** — La versión 1.0 que usamos normalmente en clase está basada en RDF, que es más compleja. La 2.0 es más sencilla y directa: solo necesitas `<channel>` e `<item>` para publicar eventos con título, descripción y fecha. Por eso la usé para este proyecto.

- **JavaScript para el calendario** — generé las filas y celdas del calendario dinámicamente con `new Date()` y `.getMonth()`. El calendario se actualiza solo al pulsar Anterior / Siguiente sin recargar la página.

- **JavaScript para los filtros** — usé `data-categoria` en los botones y `addEventListener` para mostrar u ocultar los eventos según la categoría elegida. También lee el parámetro `?cat=` de la URL para llegar con un filtro ya aplicado desde `index.html`.

- - **`URLSearchParams` y `window.location.search`** — lo uso en `eventos.html` para leer el parámetro `?cat=` de la URL. Así cuando pulsas una categoría desde `index.html`, llegas a `eventos.html` con el filtro ya aplicado automáticamente.

- **`window.location.href`** — lo uso para redirigir al usuario a `eventos.html` con la categoría ya seleccionada al pulsar una card desde la página principal.

- **`<video>` con `autoplay`, `muted` y `loop`** — el `<video>` tuve que buscar por mi cuenta que si no pones `muted` junto con `autoplay`, los navegadores bloquean el vídeo y no se reproduce solo. Con `loop` se repite en bucle.

## Lo que he usado

Para hacer el proyecto estoy trabajando con VS Code para el código, Figma para los bocetos, Oracle SQL Developer y TOAD para la base de datos, y Git para guardar los cambios con commits. Para la web uso HTML5, CSS propio, Tailwind CSS y JavaScript.
