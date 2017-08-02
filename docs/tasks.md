##Model TaxiAPP:
### User
* id
* name
* pass
* phone
### Driver
* id
* name
* car
* phone
* pass
### Car
* model
* color
* carNumbers
### Order
* id
* address to
* address from
* order state(enum)
* distance
* price
* user(client)
* driver
### Order state
* NEW / CANCEL / IN PROGRESS / DONE
### Address
* city
* street
* num

### Admin
* id
* name
* adminKay

## Admin actions
* register
* login
* changeOrderStatus
* deleteOrder


## User actions:
* register
* login
* checkAddress
* makeOrder
* getOrderInfo
* cancelOrder
* showHistory

##Driver actions:
* register
* login
* takeOrder
* finishOrder
* changeCar


