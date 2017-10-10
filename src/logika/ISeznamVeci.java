package logika;

/**
 *  Třída implementující toto rozhraní ve hře implementuje jednotlivé metody.
 *  Toto rozhraní je součástí jednoduché textové hry.
 *  
 * @author     Jekaterina Krivenchuk
 * @version    pro školní rok 2016/2017
 */
public interface ISeznamVeci
{
    public boolean obsahujeVec(String nazev);

    public Vec vlozVec(Vec vec);

    public Vec odeberVec(String nazev);

    public Vec odeberVec(Vec vec);

    public Vec odebranaVec(Vec vec);

    public Vec snezVec(Vec vec);
}
