conn = new Mongo();
db = conn.getDB("MyRetailDB");

db.products.insertMany([
    {
        name: 'Book1',
        price: '5.5',
        currency_code: 'USD',
        description: ''
    },
    {
        name: 'Book2',
        price: '70',
        currency_code: 'USD',
        description: ''
    },
    {
        name: 'Book3',
        price: '100',
        currency_code: 'USD',
        description: ''
    },
]);