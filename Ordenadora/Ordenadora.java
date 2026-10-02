public class Ordenadora extends Thread
{
    private byte[] vetor;
    private int numero;
    private Throwable erro;
    private boolean concluida;

    public Ordenadora(byte[] vetor, int numero)
    {
        if (vetor == null)
            throw new IllegalArgumentException("Vetor ausente");

        this.vetor = vetor;
        this.numero = numero;
    }

    @Override
    public void run()
    {
        long inicio = System.nanoTime();

        try
        {
            MergeSort.ordene(this.vetor);
            this.concluida = true;
        }
        catch (RuntimeException | OutOfMemoryError erro)
        {
            this.erro = erro;
        }
        finally
        {
            double tempo =
                (System.nanoTime() - inicio) / 1_000_000.0;

            System.out.printf(
                "[Ordenadora %d] %d elementos; %.3f ms; %s%n",
                this.numero,
                this.vetor.length,
                tempo,
                this.concluida ? "concluida" : "falhou"
            );
        }
    }

    public byte[] getVetor()
    {
        if (!this.concluida || this.isAlive())
        {
            throw new IllegalStateException(
                "Ordenadora ainda nao terminou ou falhou",
                this.erro
            );
        }

        return this.vetor;
    }
}