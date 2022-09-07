/* Copyright (C) 2006 M. Ben-Ari. See copyright.txt */

public class PCMonitor {
  public final int N = 1;
  public int Oldest = 0, Newest = 0;
  public volatile int Count = 0;
  public int Buffer[] = new int[N];

  public synchronized void Append(int V) {
    while (Count == N)
      try { 
        System.out.println("Esperando a que se vacie el buffer");
        wait();
      } catch (InterruptedException e) {}
		Buffer[Newest] = V;
		Newest = (Newest + 1) % N;
		Count = Count + 1;
		notifyAll();
	}

  public synchronized int Take() {
    int temp;
    while (Count == 0)
      try {
        System.out.println("Esperando nuevos mensajes"); 
        wait();
      } catch (InterruptedException e) {}
		temp = Buffer[Oldest];
		Oldest = (Oldest + 1) % N;
		Count = Count - 1;
		notifyAll();
		return temp;
	}
}
