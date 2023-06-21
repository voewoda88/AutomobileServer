# AutomobileServer

### Предметная область: Автомобильная промышленность.

### Композиция: Производитель - Автомобиль.

### Описание: 
Данное приложение предоставляет своим клиентам возможность добавлять производителей автомобилей. Производитель может содержать один или несколько автомобилей. Каждый автомобиль имеет свои характеристики, такие как название, тип кузова, год производства, тип двигателя и т.д.

### Объекты:

#### 1\. Производитель.

- Номер заказа
- Дата и время оформления заказа
- Статус заказа (оформлен, обрабатывается, отправлен, доставлен, отменен)
- Имя и фамилия клиента
- Адрес доставки

    Товар:

    Наименование товара
    Цена товара
    Описание товара
    Производитель товара
    Артикул товара

Отношение "один ко многим" между заказом и товарами означает, что один заказ может содержать несколько товаров, но каждый товар может быть связан только с одним заказом.
