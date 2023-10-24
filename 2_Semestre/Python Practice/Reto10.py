#Definimos la función para cambiar la 'cadena'
def cambia_car(cadena):
    #Guardamos en una variable la 'cadena'
    arr_cad = list(cadena)

    #Guardamos el primer carácter para poder cambiarlo con el carácter final.
    primerCaracter = arr_cad[0]

    #Cambiamos de posición la letra.
    for i in range(len(cadena) - 1):
        arr_cad[i] = arr_cad[i + 1]

    #Asignamos el último índice el primer carácter
    arr_cad[-1] = primerCaracter

    #Lo volvemos a hacer una cadena
    cadena_cambiada = ''.join(arr_cad)

    #Regresamos la cadena ya modificada.
    return cadena_cambiada

#Pedimos la cadena a ingresar
cadena = input("Introduce una cadena: ")

#Imprimimos la cadena ya modificada
print("Tu cadena cambiada es: ", cambia_car(cadena))
