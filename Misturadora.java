public class Misturadora extends Thread
{
    private byte[] esquerda;
    private byte[] direita;
    private byte[] vetor;
    private Throwable erro;

    public Misturadora(byte[] esquerda, byte[] direita)
    {
        if (esquerda == null || direita == null)
            throw new IllegalArgumentException("Vetor ausente");
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public void run()
    {
        try
        {
            this.vetor = MergeSort.intercalar(
                this.esquerda, 
                this.direita
            );
        }
        catch (RuntimeException | OutOfMemoryError erro)
        {
            this.erro = erro;
        }
    }
    
    public byte[] getVetor()
    {
        if (this.vetor == null || this.isAlive())
        {
            throw new IllegalStateException(
                "Misturadora ainda nao terminou ou falhou",
                this.erro
            );
        }

        return this.vetor;
    }
}