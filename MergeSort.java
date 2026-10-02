public class MergeSort
{
    public static void ordene(byte[] vetor)
    {
        if (vetor == null)
            throw new IllegalArgumentException("Vetor ausente");

        byte[] auxiliar = new byte[vetor.length];

        MergeSort.ordene(vetor, auxiliar, 0, vetor.length);
    }

    private static void ordene(
        byte[] vetor,
        byte[] auxiliar,
        int inicio,
        int fim
    )
    {
        if (fim - inicio <= 1)
            return;

        int meio = inicio + (fim - inicio) / 2;

        MergeSort.ordene(vetor, auxiliar, inicio, meio);
        MergeSort.ordene(vetor, auxiliar, meio, fim);

        int i = inicio;
        int j = meio;
        int k = inicio;

        while (i < meio && j < fim)
        {
            if (vetor[i] <= vetor[j])
                auxiliar[k++] = vetor[i++];
            else
                auxiliar[k++] = vetor[j++];
        }

        while (i < meio)
            auxiliar[k++] = vetor[i++];

        while (j < fim)
            auxiliar[k++] = vetor[j++];

        System.arraycopy(
            auxiliar, inicio, vetor, inicio, fim - inicio
        );
    }

    public static byte[] intercale(
        byte[] esquerda,
        byte[] direita
    )
    {
        if (esquerda == null || direita == null)
            throw new IllegalArgumentException("Vetor ausente");

        byte[] resultado = new byte[
            Math.addExact(esquerda.length, direita.length)
        ];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < esquerda.length && j < direita.length)
        {
            if (esquerda[i] <= direita[j])
                resultado[k++] = esquerda[i++];
            else
                resultado[k++] = direita[j++];
        }

        while (i < esquerda.length)
            resultado[k++] = esquerda[i++];

        while (j < direita.length)
            resultado[k++] = direita[j++];

        return resultado;
    }
}