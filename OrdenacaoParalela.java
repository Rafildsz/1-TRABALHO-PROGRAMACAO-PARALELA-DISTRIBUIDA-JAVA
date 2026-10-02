import java.util.Arrays;

public class OrdenacaoParalela
{
    public static byte[] ordene(byte[] vetor)
        throws InterruptedException
    {
        if (vetor == null)
            throw new IllegalArgumentException("Vetor ausente");

        int processadores =
            Runtime.getRuntime().availableProcessors();

        int quantidade = processadores - 1;

        System.out.println(
            "[Paralelo] Processadores: " + processadores
        );

        if (quantidade == 0)
        {
            quantidade = 1;

            System.out.println(
                "[Paralelo] Apenas um processador: " +
                "usando uma ordenadora."
            );
        }

        System.out.println(
            "[Paralelo] Dividindo em " +
            quantidade + " pedacos."
        );
    }

}
