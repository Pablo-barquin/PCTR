/**
 * @author Pablo Velicias Barquín
 */

#include <iostream>
#include <thread>
#include <ctime>

#define tam 1000

int Matriz1[tam][tam];
int Matriz2[tam][tam];
int Resultado[tam][tam];

void secuencial(int inicio, int final)
{
    for (int i = 0; i < tam; i++)
    {
        for (int j = 0; j < tam; j++)
        {
            for (int k = inicio; k < final; k++)
                Resultado[i][j] = Matriz1[i][j] + (Matriz1[i][k] * Matriz2[k][j]);
        }
    }
}

int main(){
    for (int i = 0; i < tam; i++)
    {
        for (int j = 0; j < tam; j++)
        {
            Matriz1[i][j] = i;
            Matriz2[i][j] = j;
        }
    }

    unsigned t0, t1;

    t0 = std::clock();
    std::thread t(secuencial, 0, tam);
    t.join();
    t1 = std::clock();
    double time = (double(t1-t0)/CLOCKS_PER_SEC);
    std::cout << "Tiempo Secuencial en " << time << " segundos" << std::endl;
    system("pause");

    return 0;
}
