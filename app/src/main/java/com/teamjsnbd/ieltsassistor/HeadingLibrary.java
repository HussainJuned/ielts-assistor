package com.teamjsnbd.ieltsassistor;

/**
 * Created by nuur on 8/29/2017.
 */

public class HeadingLibrary {

    String paragraphs =
            "(A) Australia's wildlife is unique. The vast majority of the animals that live there are not" +
            " found anywhere else – and things were no different 1 million years ago during the Pleistocene:" +
            " the age of the super-sized mammal. Before humanity became Earth's undisputed superpower," +
            " giant beasts of all shapes and sizes dominated every continent, but the Pleistocene mammals" +
            " of Australia were different. Some of them could grow to the size of small cars, or possessed " +
            " teeth longer than knife blades.\n" + "\n" +
            " (B) None of these animals survive today – although exactly why that's the case is a mystery. Humans," +
            " with their advanced hunting techniques and use of fire to modify the landscape, may have played a" +
            " central role in the megafauna's disappearance, but this idea is still a matter of heated debate.\n" + "\n" +
            "(C) Even if we cannot be sure that the arrival of Australian Aboriginals on the continent had catastrophic" +
            " effects on its native animals, it seems that the animals had a rather spiritual effect on the humans. The" +
            " Aboriginal mythological \"Dreamtime\" includes a cast of monstrous creatures, many of which bear a close" +
            " resemblance to some of the real-life monsters that once stalked Australia's plains. Are the myths based" +
            " in fact? Perhaps: after all, these creatures are far stranger than anything dreamed up by humans.\n" +
            "\n" +
            "(D) For instance, the two-tonnes weighting Diprotodon comfortably holds the title of largest marsupial ever." +
            " In size and appearance it looked superficially like a modern rhinoceros, but the Diprotodon seems to have" +
            "had a social lifestyle more like that of an elephant, another mammal with which it shares anatomical " +
            "similarities. What the Diprotodon most resembles, however, is exactly what it is: an enormous wombat." +
            "\n" +
            "(E) Another record breaker, this time a world champion; Varanus priscus, commonly known by its antiquated" +
            " genus name Megalania – was the largest terrestrial lizard the world has ever known. Megalania was a goanna" +
            " lizard, a relative of today's infamous Komodo dragon, and conservative estimates have predicted that it was" +
            " at least 5.5m long.\n" +
            "\n" +
            "(F) These monster marsupials were not the only giants. Their numbers were swelled by half-tonne birds" +
            " and dinosaur-like tortoises. Although this biological assemblage was truly nightmarish for humans, it" +
            " greatly enriched the Australia’s fauna and contributed to the world’s biological diversity. Unfortunately," +
            " all of these species are extinct nowadays. This fact shows us that even strong, monstrous creatures can" +
            " easily die out. So we need to care about animals that surround us today and don’t let them disappear as " +
            " it happened to their distant ancestors.";

    String  headings =
            "i. Info on the largest mammal\n" +
            "ii. Reference about Myths and reality \n" +
            "iii. Incredible creatures of Pleistocene Australia \n" +
            "iv. Importance of animal protection\n" +
            "v. Giant lizards\n" +
            "vi. 'Mystery the giants' disappearance\n"
    ;

    //d, c, a, f, e, b
    String[] answers = {"iv", "iii", "i", "vi", "v", "ii"};

    String getParragraph() {
        String s = this.paragraphs;
        return  s;
    }

    String getHeadings() {
        String s = this.headings;
        return  s;
    }

    String getAnswer(int index) {
        String s = answers[index];
        return s;
    }
}
