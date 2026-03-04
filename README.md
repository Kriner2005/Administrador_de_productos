# Administrador de Productos

Sistema de consola en Java para gestionar productos mediante una lista enlazada, desarrollado con el patrón de arquitectura **MVP (Model - View - Presenter)**.

## Detalles técnicos

### Lista enlazada manual (`MyManager`)
Los productos se almacenan en nodos enlazados. Cada `Node` contiene un `Product` y una referencia al siguiente nodo. Las operaciones principales son:

- **Agregar:** recorre la lista hasta el último nodo y enlaza el nuevo al final.
- **Eliminar:** usa dos punteros (`auxA`, `auxB`) para desconectar el nodo encontrado.
- **Ordenar:** implementa **MergeSort** sobre la lista enlazada sin modificar la lista original (trabaja sobre una copia).

## Autores
Desarrollado como proyecto universitario en la **UPTC** (Universidad Pedagógica y Tecnológica de Colombia).
- Keiner Alberto Carvajal **202320090**
- Breyner Arley Bernal **202510000**
