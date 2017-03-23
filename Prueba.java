

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Prueba.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Prueba
{
    private Muro muro1;
    private EntradaTexto entradaT1;
    private EntradaTexto entradaT2;
    private EntradaFoto entradaF1;
    private EntradaFoto entradaF2;
    private EntradaUnionAGrupo entradaU1;
    private EntradaUnionAGrupo entradaU2;

    /**
     * Default constructor for test class Prueba
     */
    public Prueba()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        muro1 = new Muro();
        entradaT1 = new EntradaTexto("Perico", "He comprado leche");
        entradaT2 = new EntradaTexto("DGT", "Si bebes no conduzcas");
        entradaF1 = new EntradaFoto("Maria", "imagen.png", "Mi gato bigotitos");
        entradaF2 = new EntradaFoto("Maria", "imagen2.png", "Mi gato calcetín");
        entradaU1 = new EntradaUnionAGrupo("Antonio", "Amantes de los loros");
        entradaU2 = new EntradaUnionAGrupo("Carlos", "Casas chulis");
        muro1.addEntrada(entradaF1);
        muro1.addEntrada(entradaF2);
        muro1.addEntrada(entradaU1);
        muro1.addEntrada(entradaT1);
        muro1.addEntrada(entradaU2);
        muro1.addEntrada(entradaT2);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}

