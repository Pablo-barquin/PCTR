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


void Paralela(int inicio, int final)
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

    unsigned t0, t1, inicio, N;
    double time;

    for(int i=0; i<5; i++)
    {
        std::thread myThreads[2+(i*2)];
        N = tam/(2+(i*2));
        inicio = 0;
        
        for(int j=0; j<2+(i*2); j++)
        {
            myThreads[j] = std::thread(Paralela, inicio, (inicio+N));
            inicio += N;
        }
        
        t0 = std::clock();
        for(int j=0; j<2+(i*2); j++)
        {
            myThreads[j].join();
        }
        t1 = std::clock();
        time = (double(t1-t0)/CLOCKS_PER_SEC);
        std::cout << "Tiempo paralelo con " << 2+(i*2) << " hilos es: " << time << " segundos" << std::endl;

    }

    system("pause");
    return 0;     
}

