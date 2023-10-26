#Complemento de Reto 11
#Importamos la Liberia Matematica
import math

#Declaramos la Funcion de Distancia
def distancia(x1, x2, y1, y2):
    '''
    (numero, numero, numero, numero) -> numero        #Type contract
    
    Retorna la distancia que existe entre dos puntos  # Description  

    >>> distancia(5, 3, 2, 5)                         # Examples
    3.605551275463989
    '''
    return math.sqrt(pow((x2 - x1), 2) + pow((y2 - y1), 2))

#Declaramos la Funcion de Pendiente y Validamos que no sea 0
def pendiente(x1, x2, y1, y2):
    '''
    (numero, numero, numero, numero) -> numero        #Type contract
    
    Retorna la distancia que existe entre dos puntos  # Description  

    >>> distancia(5, 3, 2, 5)                         # Examples
    -1.5
    '''

    if(x1 == x2): 
        return print("Las abscisas  son iguales")        
    else:
        return (y2 - y1) / (x2 - x1)

 