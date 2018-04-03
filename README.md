Run Project
$ mvn spring-boot:run

Get all Products data
HTTP Method GET
http://localhost:8089/product/getAllProductData

Get all Product Data By Product type
HTTP Method GET
http://localhost:8089/product/getProductData/{productType}

Add  Product
HTTP Method POST
http://localhost:8089/product/addProduct
Body
{
	"productName":"product",
	"productType":"headphone",
	"price":226.38
}

Remove Product
HTTP Method DELETE
http://localhost:8089/product/removeProduct/{id}

H2 database
url : http://localhost:8089/h2/
JDBC url : jdbc:h2:file:~/test
