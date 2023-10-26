def cambia_car(cadena):
    #Guardamos en una variable la 'cadena'
    arr_cad = list(cadena)

    #Cambiamos de posición la letra.
    for i in range(len(arr_cad) - 1):
        arr_cad[i + 1] = cadena[i]
    
    #Asignamos el primer índice el ultimo carácter
    arr_cad[0] = cadena[-1]

    #Lo volvemos a hacer una cadena
    cadena_cambiada = ''.join(arr_cad)

    #Regresamos la cadena ya modificada.
    return cadena_cambiada

#Pedimos la cadena a ingresar
cadena = input("Introduce una cadena: ")

#Imprimimos la cadena ya modificada
print("Tu cadena cambiada es: ", cambia_car(cadena))
