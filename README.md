# Mi Proyecto: HAPPINESS&Co

Este es el repositorio donde estaré subiendo todo el proyecto de la agenda 
cultural HAPPINESS&Co, una web para descubrir eventos culturales de Asturias: 
música, teatro, cine, arte, festivales y mucho más.

Eh organizado el proyecto en las carpetas que nos pedían:

- **Lenguaje de marcas:**
  - `index.html` — Página principal con los eventos, un vídeo de Asturias y estadísticas.
  - `eventos.html` — Todos los eventos separados en próximos y finalizados, con filtros por categoria funcionando.
  - `calendario.html` — Calendario que se genera solo con JavaScript, puedes moverte entre meses y proponer eventos desde un formulario.
  - `asturias.html` — Galeria de fotos de eventos con vídeo y texto sobre Asturias.
  - `reset.css` — Elimina los estilos por defecto del navegador.
  - `global.css` — Estilos base de toda la web (colores, fuentes, reset).
  - `style.css` — Imports.
  - `assets/imagenes/` — Logos e iconos.
  - `assets/galeria/` — Fotos de los eventos.
  - `variables.css` — Variables CSS globales (colores, fuentes y tamaños).
  - `header-footer.css` — Estilos del header y footer.
  - `componentes.css` — Estilos de tarjetas, botones y elementos reutilizables.
  - `hero-secciones.css` — Estilos del hero y las secciones principales.


- **Base de datos:** Tablas en Oracle SQL Developer (Eventos, Usuarios, Galerias, Imagenes y Favoritos) con datos de prueba, IDs automaticos, constraints y vistas. El diagrama E-R está hecho en Dia y TOAD. Los scripts están organizados en subcarpetas según el programa que use (Oracle, Toad, Dia).

- **Programación:** JavaScript para el calendario dinámico y los filtros de categoria. La parte de Java está pendiente.

- **RSS:** Archivo XML con los 3 próximos eventos en formato RSS 2.0, ya conectado al index.html.

## Sobre el diseño

Primero hice el boceto en blanco y negro para planear la estructura, luego lo  pasé a color siguiendo la paleta del PDF. Después diseñe el resto de secciones en Figma.

Eh seguido los colores del PDF:

- Rosa `#ba007c` para música y logo.
- Azul `#009bdb` para cine y teatro.
- Naranja `#ff7b00` para exposiciones.
- Gris `#555555` para textos.

## Lo que he aprendido

- **`CREATE VIEW` en Oracle SQL** — como guardar una consulta con nombre y usarla como si fuera una tabla normal.
- **`SEQUENCE`** — en Oracle no existe AUTO_INCREMENT, hay que crear una secuencia aparte para los IDs.
- **`ON DELETE CASCADE`** — si borras un evento se borran automaticamente sus galerias e imagenes.
- **CSS Grid (`display: grid`)** — para que las imagenes de la galeria se coloquen solas en varias columnas.
- **`tailwind.config`** — para añadir mis propios colores y usarlos como clases en el HTML.
- **RSS 2.0** — más sencilla que la 1.0, solo necesitas `<channel>` e `<item>` para publicar eventos.
- **JavaScript para el calendario** — con `new Date()` y `.getMonth()`. Dato: enero es 0 en JavaScript (no el 1).
- **JavaScript para los filtros** — `data-categoria` en los botones y `addEventListener` para mostrar u ocultar eventos.
- **`URLSearchParams`** — para leer `?cat=` de la URL y llegar a `eventos.html` con el filtro ya aplicado.
- **`<video>` con `autoplay`, `muted` y `loop`** — sin `muted` los navegadores bloquean el autoplay.
- **`@keyframes`** — para animar los lazos del logo con `translateY` y `rotate`.
- **Gradiente en texto** — `linear-gradient` + `background-clip: text` para que se vean los colores a traves de las letras.
- **`aspect-ratio: 16/9`** — para que los vídeos de YouTube no se deformen en ningun tamaño.
- **Bordes con gradiente en las cards** — con `padding-box` y `border-box` para mezclar colores sin afectar el fondo.
- **Separar el CSS** — dividir un archivo grande en varios más pequeños por sección, así es más fácil encontrar los fallos y hacer cambios de diseño.
- **Reemplazo masivo en VS Code** — para cambiar rutas de muchos archivos a la vez sin tener que ir uno a uno.


## Lo que he usado

VS Code, Figma, Oracle SQL Developer, TOAD, Git y GitHub. HTML, CSS, Tailwind CSS y JavaScript.
