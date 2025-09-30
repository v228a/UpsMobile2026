package com.vovka.upsmobile.entity

import com.vovka.upsmobile.R

object TestData {
    val points: List<PointEntity> = listOf(
        PointEntity(
            latitude = 55.751225,
            longitude = 37.62954,
            title = "Москва",
            description = "Столица России, крупнейший город страны, политический, экономический и культурный центр."
        ),
        PointEntity(
            latitude = 59.93428,
            longitude = 30.33509,
            title = "СПб",
            description = "Санкт-Петербург — культурная столица России, город на Неве с богатой историей и архитектурой."
        ),
        PointEntity(
            latitude = 43.414807,
            longitude = 39.950908,
            title = "Сириус",
            description = "Мой любимый сириус, Место проведения уральской проектной смены"
        ),
        PointEntity(
            latitude = 56.838011,
            longitude = 60.597474,
            title = "Екатеринбург",
            description = "Город на Урале, исторический и промышленный центр, делит страну на европейскую и азиатскую части."
        ),
        PointEntity(
            latitude = 54.73479,
            longitude = 55.95785,
            title = "Уфа",
            description = "Столица Республики Башкортостан, важный промышленный и культурный центр на юге Урала."
        )
    )
    val tests: List<TestItem> = listOf(
        TestItem(
            id = "math5_arith",
            title = "Арифметика",
            course = "5 класс",
            image = R.drawable.math,
            questions = listOf(
                Question(
                    text = "Найдите значение: 456 – 289",
                    answer = "167"
                ),
                Question(
                    text = "Решите уравнение: 7x = 49",
                    answer = "7"
                ),
                Question(
                    text = "Вычислите: (125 ÷ 5) + 32",
                    answer = "57"
                ),
                Question(
                    text = "Найдите значение: 2³ + 4²",
                    answer = "24"
                ),
                Question(
                    text = "Сколько будет 15% от 200?",
                    answer = "30"
                )
            )
        ),
        TestItem(
            id = "math5_geom",
            title = "Геометрия",
            course = "5 класс",
            image = R.drawable.math,
            questions = listOf(
                Question(
                    text = "Сколько сторон у правильного шестиугольника?",
                    answer = "6"
                ),
                Question(
                    text = "Чему равна сумма углов треугольника?",
                    answer = "180"
                ),
                Question(
                    text = "Периметр квадрата равен 48 см. Чему равна сторона?",
                    answer = "12"
                ),
                Question(
                    text = "Найдите площадь прямоугольника со сторонами 9 см и 7 см.",
                    answer = "63"
                ),
                Question(
                    text = "Сколько рёбер у куба?",
                    answer = "12"
                )
            )
        ),
        TestItem(
            id = "math5_logic",
            title = "Логика и задачи",
            course = "5 класс",
            image = R.drawable.pic2,
            questions = listOf(
                Question(
                    text = "В коробке лежат 5 красных, 3 синих и 2 зелёных карандаша. Сколько всего карандашей?",
                    answer = "10"
                ),
                Question(
                    text = "У Кати было 50 рублей. Она купила тетрадь за 18 рублей. Сколько осталось?",
                    answer = "32"
                ),
                Question(
                    text = "У автобуса 4 колеса. Сколько колёс у 3 автобусов?",
                    answer = "12"
                ),
                Question(
                    text = "В одном десятке сколько единиц?",
                    answer = "10"
                ),
                Question(
                    text = "Продолжите ряд: 2, 4, 8, 16, ...",
                    answer = "32"
                )
            )
        ),
        TestItem(
            id = "math5_fractions",
            title = "Дроби и проценты",
            course = "5 класс",
            image = R.drawable.pic2,
            questions = listOf(
                Question(
                    text = "Найдите: 1/2 + 1/4",
                    answer = "3/4"
                ),
                Question(
                    text = "Вычислите: 2/3 – 1/6",
                    answer = "1/2"
                ),
                Question(
                    text = "Сколько будет 25% от 80?",
                    answer = "20"
                ),
                Question(
                    text = "Запишите десятичную дробь для 3/10",
                    answer = "0.3"
                ),
                Question(
                    text = "Найдите: 40% от 250",
                    answer = "100"
                )
            )
        ),
        TestItem(
            id = "math5_mix",
            title = "Смешанные задачи",
            course = "5 класс",
            image = R.drawable.pic3,
            questions = listOf(
                Question(
                    text = "В саду 24 яблони и 36 груш. Во сколько раз больше груш, чем яблонь?",
                    answer = "1.5"
                ),
                Question(
                    text = "Масса арбуза 8 кг, а дыня на 3 кг легче. Сколько весит дыня?",
                    answer = "5"
                ),
                Question(
                    text = "На складе было 120 кг муки. Продали 30%. Сколько кг осталось?",
                    answer = "84"
                ),
                Question(
                    text = "Сколько сантиметров в 1/4 метра?",
                    answer = "25"
                ),
                Question(
                    text = "У Пети было 45 тетрадей, он раздал друзьям 15. Какая часть тетрадей у него осталась?",
                    answer = "2/3"
                )
            )
        )
    )

    fun findTestById(id: String): TestItem? = tests.find { it.id == id }
}

