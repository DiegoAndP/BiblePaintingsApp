package com.example.biblicalpaintings.datasource

import com.example.biblicalpaintings.R
import com.example.biblicalpaintings.model.Painting

object PaintingList {
    val paintings = listOf(
        Painting(
            id = 1, paintingName = R.string.painting_virgin_rocks,
            paintingImage = R.drawable.virgin_of_the_rock,
            authorName = R.string.author_leonardo_da_vinci,
            creationStart = 1483,
            creationEnd = 1486,
            pictureInfo = R.string.virgin_rocks_info
        ),
        Painting(
            id = 2, paintingName = R.string.painting_last_supper,
            paintingImage = R.drawable.the_last_supper,
            authorName = R.string.author_leonardo_da_vinci,
            creationStart = 1495,
            creationEnd = 1498,
            pictureInfo = R.string.last_supper_info
        ),
        Painting(
            id = 3, paintingName = R.string.painting_creation_of_adam,
            paintingImage = R.drawable.creation_of_adam_,
            authorName = R.string.author_michelangelo,
            creationStart = 1508,
            creationEnd = 1512,
            pictureInfo = R.string.creation_of_adam_info
        ),
        Painting(
            id = 4, paintingName = R.string.painting_disputation_holy_sacrament,
            paintingImage = R.drawable.disputation_for_the_holy_sacrament,
            authorName = R.string.author_raphael,
            creationStart = 1509,
            creationEnd = 1510,
            pictureInfo = R.string.disputation_holy_sacrament_info
        ),
        Painting(
            id = 5, paintingName = R.string.painting_sistine_madonna,
            paintingImage = R.drawable.sistine_madonna,
            authorName = R.string.author_raphael,
            creationStart = 1512,
            creationEnd = 1513,
            pictureInfo = R.string.sistine_madonna_info
        ),
        Painting(
            id = 6, paintingName = R.string.painting_last_judgement,
            paintingImage = R.drawable.the_last_judgement,
            authorName = R.string.author_michelangelo,
            creationStart = 1536,
            creationEnd = 1541,
            pictureInfo = R.string.last_judgement_info
        ),
        Painting(
            id = 7, paintingName = R.string.painting_conversion_saint_paul,
            paintingImage = R.drawable.the_conversion_of_saint_paul,
            authorName = R.string.author_caravaggio,
            creationStart = 1600,
            creationEnd = null,
            pictureInfo = R.string.conversion_saint_paul_info
        ),
        Painting(
            id = 8, paintingName = R.string.painting_coronation_virgin,
            paintingImage = R.drawable.coronation_of_the_virgin,
            authorName = R.string.author_diego_velazques,
            creationStart = 1641,
            creationEnd = 1644,
            pictureInfo = R.string.coronation_virgin_info
        ),
        Painting(
            id = 9, paintingName = R.string.painting_return_prodigal_son,
            paintingImage = R.drawable.prodigal_son,
            authorName = R.string.author_rembrandt,
            creationStart = 1663,
            creationEnd = 1669,
            pictureInfo = R.string.return_prodigal_son_info
        ),
        Painting(
            id = 10, paintingName = R.string.painting_immaculate_conception_los_venerables,
            paintingImage = R.drawable.immaculate_conception,
            authorName = R.string.author_bartolomé_esteban,
            creationStart = 1678,
            creationEnd = null,
            pictureInfo = R.string.immaculate_conception_los_venerables_info
        )
    )
}