package net.sf.extjwnl.princeton.data;

import net.sf.extjwnl.data.Adjective;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.data.Synset;
import net.sf.extjwnl.data.Word;
import net.sf.extjwnl.dictionary.Dictionary;
import net.sf.extjwnl.util.factory.Param;

import java.util.Map;

/**
 * <code>FileDictionaryElementFactory</code> that produces elements for Princeton's release of WordNet v 1.6
 *
 * @author John Didion <jdidion@users.sourceforge.net>
 * @author Aliaksandr Autayeu <avtaev@gmail.com>
 */
public class PrincetonWN16FileDictionaryElementFactory extends AbstractPrincetonFileDictionaryElementFactory {

    public PrincetonWN16FileDictionaryElementFactory(Dictionary dictionary, Map<String, Param> params) {
        super(dictionary);
    }

    protected Word createWord(Synset synset, int index, String lemma) {
        if (synset.getPOS().equals(POS.ADJECTIVE)) {
            Adjective.AdjectivePosition adjectivePosition = Adjective.NONE;
            if (lemma.charAt(lemma.length() - 1) == ')' && lemma.indexOf('(') > 0) {
                int lparen = lemma.indexOf('(');
                String marker = lemma.substring(lparen + 1, lemma.length() - 1);
                adjectivePosition = Adjective.getAdjectivePositionForKey(marker);
                lemma = lemma.substring(0, lparen);
            }
            return new Adjective(dictionary, synset, index, lemma, adjectivePosition);
        } else {
            return super.createWord(synset, index, lemma);
        }
    }
}
