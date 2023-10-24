/************************************************************************/
/**
* @file Program.cs
* @author Angel Inda <a18.inda@gmail.com>
* @date 2023/04/19
* @brief A simple ATM for first semester. 
*
* @bug No bug known.
*/
/************************************************************************/

using System;
using System.IO;

//Struct to declare Users 
public struct User {
    public int id;
    public int password;
    public string accountName;
    public string numberCard;
    public int cvcCard;
    public DateTime dateCard;
    public float balanceCard;
};

namespace Evidencia {
    class Program {

        //Function to display a menu.
         static int ShowMenu(int option) {           
            Console.WriteLine("\nWelcome to ATM");
            Console.WriteLine("1.- Retire Money");
            Console.WriteLine("2.- Transfer Money");
            Console.WriteLine("3.- Deposit Money");
            Console.WriteLine("4.- Check Balance");
            Console.WriteLine("5.- Exit");
            Console.Write("Option: ");
            return option = Int32.Parse(Console.ReadLine());
        }

        //Function to retire money in the ATM.
        static void Retire(User[] user, int id) {
            float retire = 0;

            Console.WriteLine("\nRetire Money");
            Console.WriteLine("How much money do you want to withdraw?");
            retire = float.Parse(Console.ReadLine());

            //We verify that you have enough money.
            if (retire < user[id].balanceCard) {
                user[id].balanceCard -= retire;
                Console.WriteLine("\nSuccessfully Operation");
                Console.WriteLine("Actual Balance: ");
                Console.WriteLine(user[id].balanceCard);
            }
            else {
                Console.WriteLine("You don't have enough money");
            }
        }

        //Function to transfer money to another account.
        static void Transfer(User[] user, int id) {
            float transfer = 0;
            string transferAccount = "";

            Console.WriteLine("\nTransfer Money");
            Console.WriteLine("Which account do you want to transfer?");
            transferAccount = Console.ReadLine();

            bool exitFor = false;
            for (int i = 0; i < user.Length; i++) {
                //We verify that it has the person to transfer.
                if (transferAccount == user[i].accountName) {
                    exitFor = true;
                    Console.WriteLine("\nTransfer to " + user[i].accountName);
                    Console.WriteLine("How much money do you want to transfer?");
                    transfer = float.Parse(Console.ReadLine());

                    //Verify that you have enough money.
                    if (transfer < user[id].balanceCard) {
                        user[id].balanceCard -= transfer;
                        user[i].balanceCard += transfer;
                        Console.WriteLine("\nSuccessfully Operation");
                        Console.WriteLine("Actual Balance: ");
                        Console.WriteLine(user[id].balanceCard);
                    }
                    else {
                        Console.WriteLine("You don't have enough money");
                    }
                }
            }
            if (exitFor == false) { 
                Console.WriteLine("You do not have that registered account");
            }
        }

        //Function to deposit a number card.    
        static void Depositar(User[] user, int id) {
            string depositarTarjeta = " ";
            float depositar = 0;

            Console.WriteLine("\nDepositar Dinero");
            Console.WriteLine("A que tarjeta quieres depositar?");
            depositarTarjeta = Console.ReadLine();

            bool exitFor = false;
            for (int i = 0; i < user.Length; i++) {
                //Verificamos que exista el num. de Tarjeta
                if (depositarTarjeta == user[i].numberCard) {
                    exitFor = true;
                    Console.WriteLine("\nDepositar a " + user[i].accountName);

                    bool isBilletes = false;
                    while (isBilletes == false) {
                        Console.WriteLine("Cuanto dinero quieres depositar?");
                        depositar = float.Parse(Console.ReadLine());

                        //Checamos si todos son billetes
                        float billetes = depositar;
                        billetes %= 500;
                        billetes %= 100;
                        billetes %= 50;
                        billetes %= 20;

                        if (billetes == 0) {
                            isBilletes = true;

                            //Verificamos que tenga el dinero suficiente.
                            if (depositar < user[id].balanceCard) {
                                user[id].balanceCard -= depositar;
                                user[i].balanceCard += depositar;
                                Console.WriteLine("\nOperación exitosa");
                                Console.WriteLine("Saldo actual: ");
                                Console.WriteLine(user[id].balanceCard);
                            }
                            else {
                                Console.WriteLine("No cuentas con el dinero suficiente");
                            }
                        }
                        else {
                            Console.WriteLine("Introduce solo billetes\n");
                        }
                    }
                }
            }
            if (exitFor == false) {
                Console.WriteLine("No tienes esa cuenta registada");
            }
        }
        static void Saldo(User[] user, int id) {
            //Mostramos su Saldo.
            Console.WriteLine("\nChecar Saldo");
            Console.WriteLine("Saldo: " + user[id].balanceCard);

            //Lo imprimimos en un .txt
            int opcion = 0;

            Console.WriteLine("\nQuieres imprimir tu saldo?");
            Console.WriteLine("1.- Si");
            Console.WriteLine("2.- No");
            opcion = int.Parse(Console.ReadLine());
            if (opcion == 1) {
                string filePath = "C:/Users/angel/source/repos/TecMilenio/FirstSemester/balance.txt";
                string data = "Saldo: " + user[id].balanceCard.ToString();

                using (StreamWriter writer = new StreamWriter(filePath)) {
                    writer.Write(data);
                }
            }            
        }

        //Funcion Main
        static void Main(string[] args) {
            //Declarar Users
            string path = "C:/Users/angel/source/repos/TecMilenio/FirstSemester/users.txt";
            string[] lines = File.ReadAllLines(path);
            User[] user = new User[lines.Length];

            for (int i = 0; i < lines.Length; i++) {
                string[] campos = lines[i].Split(';');
                user[i] = new User {
                    id = int.Parse(campos[0]),
                    password = int.Parse(campos[1]),
                    accountName = campos[2],
                    numberCard = campos[3],
                    cvcCard = int.Parse(campos[4]),
                    dateCard = DateTime.ParseExact(campos[5], "yyyy-MM-dd", null),
                    balanceCard = float.Parse(campos[6])
                };
            }

            //Variables para la Fecha
            DateTime fechaActual = DateTime.Now;

            //Variables para el Cajero
            int id = 0;
            int contador = 0;
            
            //El User ingresa la tarjeta de manera física.
            //While para hacer un chequeo de contraseña.
            while (contador < 3) {
                Console.WriteLine("Ingrese clave: ");
                int clave = Int32.Parse(Console.ReadLine());

                bool exitClave = false;
                for (int i = 0; i < user.Length; i++) {
                    if (clave == user[i].password) {
                        exitClave = true;
                        contador = 4;
                        id = user[i].id;

                        //Checamos que la tarjeta no haya expirado
                        if (fechaActual < user[i].dateCard) {
                       
                            bool exitMenu = false;
                            //While para que se repita el menu hasta que el User quiera salir.
                            while (exitMenu == false) {                         
                                int opcion = 0;
                                opcion = ShowMenu(opcion);

                                //Enter the option "Retire Money".
                                if (opcion == 1) {
                                    Retire(user, user[i].id);                                    
                                }
                                //Entramos a la opcion "Transfer Dinero".
                                if (opcion == 2) {
                                    Transfer(user, user[i].id);                                  
                                }
                                //Entramos a la opcion "Depositar Dinero".
                                if (opcion == 3) {
                                    Depositar(user, user[i].id);
                                }
                                //Entramos a la opcion "Checar Saldo".
                                if (opcion == 4) {
                                    Saldo(user, user[i].id);                                
                                }
                                //Exit ATM
                                if(opcion >= 5) {
                                    break;
                                }
                            }
                        }
                        else {
                            Console.WriteLine("\nYour card has already expired");
                        }
                    }                                    
                }
                if (exitClave == false) {
                    contador += 1;
                    //Verificamos que ya se agoto su numero de intentos
                    if (contador == 3) {
                        Console.WriteLine("\nYou have failed all 3 attempts");
                    }
                    else {
                        Console.WriteLine("Incorrect Password\n");
                    }
                }
            }
        }        
    }
}
