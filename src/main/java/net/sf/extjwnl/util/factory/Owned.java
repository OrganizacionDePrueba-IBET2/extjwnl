package net.sf.extjwnl.util.factory;

import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.dictionary.Dictionary;

/**
 * Supports ownership information.
 *
 * @author Aliaksandr Autayeu <avtaev@gmail.com>
 */
public interface Owned {

    /**
     * Returns the dictionary this object belongs to.
     *
     * @return the dictionary this object belongs to
     */
    Dictionary getDictionary();

    /**
     * Sets the dictionary this object belongs to.
     *
     * @param dictionary the dictionary this object belongs to
     */
    void setDictionary(Dictionary dictionary) throws JWNLException;
}
