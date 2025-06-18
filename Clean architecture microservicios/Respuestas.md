
## 6. Preguntas y Respuestas sobre Clean Architecture

### 1. ¿Cuál es el propósito principal de Clean Architecture en el desarrollo de software?

El propósito principal de Clean Architecture es **separar las responsabilidades** del software en capas bien definidas, permitiendo una alta **independencia entre los componentes**. Esto facilita el mantenimiento, la prueba, la escalabilidad y la evolución del sistema sin generar un fuerte acoplamiento entre las partes del código.

---

### 2. ¿Qué beneficios aporta Clean Architecture a un microservicio en Spring Boot?

- **Desacoplamiento** entre capas de negocio y tecnología.
- **Facilidad para realizar pruebas unitarias** de la lógica de negocio sin depender del framework.
- **Mayor mantenibilidad** del código a lo largo del tiempo.
- **Escalabilidad**, ya que cada capa puede evolucionar independientemente.
- **Reutilización** de lógica de negocio en otros contextos (por ejemplo, CLI, REST, batch jobs).

---

### 3. ¿Cuáles son las principales capas de Clean Architecture y qué responsabilidad tiene cada una?

1. **Entidad (Domain Model)**: Representa las reglas de negocio de más alto nivel.
2. **Casos de uso (Application)**: Contiene la lógica de aplicación, orquestando la ejecución de los flujos de negocio.
3. **Interfaz (Interface Adapters)**: Adapta datos para que puedan ser consumidos o enviados desde/hacia el exterior (controladores, DTOs, mapeadores, repositorios).
4. **Infraestructura (Frameworks & Drivers)**: Incluye tecnologías externas como bases de datos, frameworks web, mensajería, etc.

---

### 4. ¿Por qué se recomienda desacoplar la lógica de negocio de la infraestructura en un microservicio?

Porque permite que la lógica de negocio **no dependa de detalles tecnológicos** o externos (como JPA, frameworks web o bases de datos). Esto mejora la **portabilidad**, **testabilidad** y **durabilidad** del software, permitiendo reemplazar partes externas sin modificar el núcleo del sistema.

---

### 5. ¿Cuál es el rol de la capa de aplicación y qué tipo de lógica debería contener?

La capa de aplicación (Application Layer) orquesta los **casos de uso** del sistema. Su lógica consiste en coordinar entidades, verificar reglas del negocio y definir los pasos para cumplir con una operación solicitada (por ejemplo, crear una orden o procesar un pago). No debe tener lógica de presentación ni de persistencia.

---

### 6. ¿Qué diferencia hay entre un `UseCase` y un `Service` en Clean Architecture?

- `UseCase`: Representa una acción específica del negocio (crear usuario, procesar pedido), centrado en **qué se quiere lograr**.
- `Service`: En el contexto de Spring, es un componente técnico que puede contener lógica de aplicación, pero en Clean Architecture, lo ideal es que los servicios sean simplemente **adaptadores** que invocan los casos de uso, no que contengan lógica directamente.

---

### 7. ¿Por qué se recomienda definir `Repositories` como interfaces en la capa de dominio en lugar de usar directamente `JpaRepository`?

Porque `JpaRepository` es una implementación específica de persistencia, lo que introduce **dependencias tecnológicas** en la capa de dominio. Definir una interfaz abstracta permite aplicar **inyección de dependencias** y aislar el dominio de los detalles de infraestructura, cumpliendo con el principio de inversión de dependencias (D de SOLID).

---

### 8. ¿Cómo se implementa un `UseCase` en un microservicio con Spring Boot y qué ventajas tiene?

Se implementa como una clase de aplicación pura que orquesta entidades y lógica del dominio, inyectando interfaces como repositorios definidos en la capa de dominio. Luego, un controlador (adapter) lo llama.

**Ventajas:**
- Código más limpio y organizado.
- Fácil de probar (sin levantar el contexto de Spring).
- Alta cohesión y bajo acoplamiento.

---

### 9. ¿Qué problemas podrían surgir si no aplicamos Clean Architecture en un proyecto de microservicios?

- Código difícil de mantener o escalar.
- Acoplamiento entre capas técnicas y lógica de negocio.
- Dificultad para escribir pruebas automatizadas.
- Dependencia de frameworks o tecnologías específicas.
- Mayor esfuerzo para refactorizar o migrar partes del sistema.

---

### 10. ¿Cómo Clean Architecture facilita la escalabilidad y mantenibilidad en un entorno basado en microservicios?

Permite escalar funcionalidades de forma independiente gracias a la separación de responsabilidades. Cada microservicio puede evolucionar internamente sin afectar a otros. Además, al estar bien estructurado, el código es más fácil de mantener, extender y comprender por nuevos desarrolladores.
