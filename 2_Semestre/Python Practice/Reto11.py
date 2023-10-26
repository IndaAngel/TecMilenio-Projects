#Importamos el geoanalitic
import geoanalitic

#Llamamos Distancia. Ej 1
print("Distancia: ", geoanalitic.distancia(5, 3, 2, 5))

#Llamamos Pendiente. Ej 1
print("Pendiente: ", geoanalitic.pendiente(5, 3, 2, 5))

#Llamamos Distancia. Ej 2
print("Distancia: ", geoanalitic.distancia(-1, 9, 4, 10))

#Llamamos Pendiente. Ej 2
print("Pendiente: ", geoanalitic.pendiente(3, 3, 2, 5))

#Llamamos Distancia. Ej 3
print("Distancia: ", geoanalitic.distancia(26, 35, 23, 40))

#Llamamos Pendiente. Ej 3
print("Pendiente: ", geoanalitic.pendiente(5, 4, 9, 30))

#Llamamos la funcion Help para saber que hacen las funciones
help(geoanalitic.distancia)
help(geoanalitic.pendiente)