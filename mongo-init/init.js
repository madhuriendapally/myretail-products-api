conn = new Mongo();
db = conn.getDB("MyRetailDB");

db.products.insertMany([
    {
        _id: 123456,
        current_price: {
            value: 15.55,
            currency_code: 'USD'
        }
    },
    {
        _id: 345678,
        current_price: {
            value: 100,
            currency_code: 'USD'
        }
    },
    {
        _id: 890674,
        current_price: {
            value: 120.56,
            currency_code: 'USD'
        }
    },
]);