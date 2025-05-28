package com.example.swastha;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Awareness extends AppCompatActivity {
    private RecyclerView recyclerView;
    private InfoAdapter adapter;
    private List<InfoItem> infoList;
    private EditText searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awareness);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample Data
        infoList = new ArrayList<>();
        infoList.add(new InfoItem(
                "Kwashiorkor",
                "<b>Kwashiorkor</b> is a severe form of malnutrition caused by extreme protein deficiency, typically affecting children in developing regions. " +
                        "It is characterized by edema (swelling), an enlarged liver, skin changes, irritability, and muscle wasting. " +
                        "The disease primarily occurs when children consume a diet high in carbohydrates but deficient in protein. " +
                        "The lack of essential amino acids needed for body functions leads to fluid retention, which causes the swollen belly appearance. " +
                        "If left untreated, kwashiorkor can result in severe growth retardation, immune system suppression, and ultimately, death. " +
                        "Early diagnosis and treatment are crucial, including dietary interventions and medical management to restore protein balance in the body.<br><br>" +
                        "<b>How it Happens:</b> Occurs due to inadequate protein intake, common in famine-stricken areas.<br><br>" +
                        "<b>How to Prevent:</b> Balanced diet with protein-rich foods.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Increase protein intake by consuming eggs, milk, fish, legumes, soybeans, peanuts, and cheese.<br><br>" +
                        "<b>Medicine:</b> Therapeutic foods like Plumpy'Nut (ready-to-use therapeutic food), F-75 and F-100 formulas.<br><br>" +
                        "<b>More Information:</b> https://my.clevelandclinic.org/health/diseases/23099-kwashiorkor"
        ));
        infoList.add(new InfoItem(
                "Vitamin A Deficiency",
                "<b>Vitamin A Deficiency</b> occurs when the body does not get enough vitamin A, which is essential for vision, immune function, and cellular growth. " +
                        "This deficiency can lead to night blindness, dry eyes, corneal ulcers, and increased susceptibility to infections. " +
                        "Vitamin A plays a vital role in maintaining the integrity of skin and mucous membranes, which act as a barrier against bacteria and viruses. " +
                        "In children, deficiency in vitamin A increases the risk of severe illnesses and even death due to measles and diarrhea. " +
                        "Prolonged deficiency can cause irreversible blindness, making it a critical health concern in many developing countries. " +
                        "The World Health Organization (WHO) recommends supplementation programs in high-risk areas to prevent deficiency-related disorders.<br><br>" +
                        "<b>How it Happens:</b> Poor diet lacking dairy, eggs, and leafy greens.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Consume vitamin A-rich foods like carrots, liver, sweet potatoes, spinach, and mangoes.<br><br>" +
                        "<b>Recommended Diet:</b> Include foods rich in vitamin A such as carrots, papaya, tomatoes, and bell peppers.<br><br>" +
                        "<b>Medicine:</b> Vitamin A supplements like Retinol, Beta-Carotene capsules.<br><br>" +
                        "<b>More Information:</b> https://my.clevelandclinic.org/health/diseases/23107-vitamin-a-deficiency"
        ));

        infoList.add(new InfoItem(
                "Iron deficiency anemia",
                "<b>Iron deficiency anemia</b> Iron deficiency anemia occurs when the body lacks enough iron to produce adequate hemoglobin, the protein in red blood cells responsible for oxygen transport. This leads to symptoms such as fatigue, weakness, pale skin, shortness of breath, and dizziness. It is the most common nutritional deficiency worldwide, affecting women, children, and people with chronic diseases. The condition often results from inadequate dietary iron intake, blood loss due to menstruation, pregnancy, or gastrointestinal bleeding. If left untreated, iron deficiency anemia can impair cognitive development in children and decrease productivity in adults. Proper treatment involves dietary modifications, iron supplementation, and addressing the underlying cause of blood loss.<br><br>" +
                        "<b>How it Happens:</b> Poor dietary iron intake, blood loss.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Eat iron-rich foods like red meat, spinach, legumes, fortified cereals, and tofu.<br><br>" +
                        "<b>Recommended Diet:</b> Consume iron-rich foods like beetroots, pomegranates, dates, apples, and sesame seeds.<br><br>" +
                        "<b>Medicine:</b> Ferrous sulfate tablets, Ferrous fumarate, Ferrous gluconate supplements.<br><br>" +
                        "<b>More Information:</b> https://my.clevelandclinic.org/health/diseases/22824-iron-deficiency-anemia"
        ));

        infoList.add(new InfoItem(
                "Marasmus disease",
                "<b>Marasmus disease</b> Marasmus is a severe form of malnutrition that results from prolonged deficiency in energy, protein, and essential nutrients. It commonly affects children in regions where food scarcity is prevalent. Unlike kwashiorkor, marasmus does not cause edema but leads to extreme muscle wasting, growth failure, and weakened immunity. Affected children appear extremely thin, with visible bones and little to no fat. Marasmus can lead to severe dehydration, hypothermia, and death if not treated promptly. The condition is often associated with poverty, inadequate breastfeeding, and frequent infections that reduce nutrient absorption. Treatment involves nutritional rehabilitation, rehydration, and gradual refeeding with nutrient-dense foods.<br><br>" +
                        "<b>How it Happens:</b> Starvation or severe food shortage.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Proper nutrition and adequate calorie intake.<br><br>" +
                        "<b>Recommended Diet:</b> High-calorie, high-protein diet including milk, bananas, nuts, avocados, and ghee.<br><br>" +
                        "<b>Medicine:</b> Ready-to-use therapeutic food (RUTF), Plumpy'Nut, F-75 and F-100 formulas<br><br>" +
                        "<b>More Information:</b> https://my.clevelandclinic.org/health/diseases/23296-marasmus"
        ));

        infoList.add(new InfoItem(
                "Rickets",
                "<b>Rickets</b> Rickets is a skeletal disorder caused by prolonged vitamin D, calcium, or phosphate deficiency, leading to weak and deformed bones. It primarily affects children, causing symptoms such as bowed legs, delayed growth, muscle weakness, and dental issues. The condition is often due to insufficient sun exposure, poor diet, or malabsorption disorders. Severe rickets can cause bone pain and increase the risk of fractures. Preventing rickets involves ensuring adequate vitamin D intake through diet and sunlight exposure. In severe cases, medical intervention with vitamin D and calcium supplements is required to correct bone abnormalities.<br><br>" +
                        "<b>How it Happens:</b> Lack of sunlight, poor calcium and vitamin D intake.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Sun exposure and calcium-rich foods.<br><br>" +
                        "<b>Recommended Diet:</b> Consume dairy products like milk, cheese, yogurt, and calcium-rich vegetables like kale and broccoli.<br><br>" +
                        "<b>Medicine:</b> Vitamin D supplements such as Cholecalciferol (D3), Ergocalciferol (D2), Calcium carbonate tablets.<br><br>" +
                        "<b>More Information:</b> https://my.clevelandclinic.org/health/diseases/22459-rickets"
        ));

        infoList.add(new InfoItem(
                "Zinc deficiency",
                "<b>Zinc deficiency</b> Zinc deficiency is a condition where the body lacks sufficient zinc, an essential mineral required for immune function, wound healing, growth, and DNA synthesis. Common symptoms include hair loss, weakened immunity, delayed wound healing, diarrhea, and growth retardation in children. Zinc deficiency is prevalent in individuals with poor dietary intake, malabsorption disorders, chronic alcoholism, and severe illnesses. The body does not store excess zinc, so regular intake is necessary. Zinc-rich foods include meat, shellfish, legumes, nuts, and dairy. In severe cases, supplementation is required to prevent complications such as developmental delays and increased infection risks.<br><br>" +
                        "<b>How it Happens:</b> Poor diet, malabsorption issues.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Include zinc-rich foods (meat, nuts, dairy).<br><br>" +
                        "<b>Recommended Diet:</b> Consume pumpkin seeds, chickpeas, cashews, and dairy products.<br><br>" +
                        "<b>Medicine:</b> Zinc sulfate tablets, Zinc gluconate lozenges, Zinc acetate supplements.<br><br>" +
                        "<b>More Information:</b> https://www.healthdirect.gov.au/zinc-deficiency"
        ));

        infoList.add(new InfoItem(
                "Scurvy disease",
                "<b>Scurvy disease</b> Scurvy is a disease caused by a severe deficiency of vitamin C (ascorbic acid), leading to weakness, anemia, gum disease, and skin problems. Vitamin C is crucial for collagen production, and its absence leads to fragile blood vessels, bleeding gums, and poor wound healing. Historically, scurvy was common among sailors who lacked fresh fruits and vegetables for long periods.<br><br>" +
                        "<b>How it Happens:</b> Insufficient intake of vitamin C-rich foods.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Consuming fruits and vegetables rich in vitamin C.<br><br>" +
                        "<b>Recommended Diet:</b> Include citrus fruits like oranges, lemons, strawberries, and vegetables like bell peppers and broccoli in the diet.<br><br>" +
                        "<b>Medicine:</b> Vitamin C supplements such as Ascorbic Acid tablets or chewable tablets.<br><br>" +
                        "<b>More Information:</b> https://my.clevelandclinic.org/health/diseases/24318-scurvy"
        ));

        infoList.add(new InfoItem(
                "Cheilosis",
                "<b>Cheilosis</b> Cheilosis, also known as angular cheilitis, is a condition caused by a deficiency of riboflavin (Vitamin B2), resulting in cracked lips, sores at the corners of the mouth, and inflammation. It often occurs in malnourished individuals and those with weakened immunity.<br><br>" +
                        "<b>How it Happens:</b> Lack of vitamin B2 in the diet, poor oral hygiene, or infections.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Adequate intake of vitamin B2-rich foods like eggs, dairy products, and leafy greens.<br><br>" +
                        "<b>Recommended Diet:</b> Increase intake of dairy, lean meats, mushrooms, and almonds.<br><br>" +
                        "<b>Medicine:</b> Riboflavin supplements (Vitamin B2) in tablet or capsule form.<br><br>" +
                        "<b>More Information:</b> https://www.webmd.com/oral-health/angular-cheilitis"
        ));

        infoList.add(new InfoItem(
                "Clubbing",
                "<b>Clubbing</b> Clubbing refers to the swelling and rounding of fingertips and nails, often associated with chronic diseases and malnutrition. It occurs due to reduced oxygen supply and chronic inflammation, usually linked to heart or lung diseases, but it can also be due to poor nutrition.<br><br>" +
                        "<b>How it Happens:</b> Chronic illness, malnutrition, or long-term oxygen deficiency.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Maintaining a balanced diet, treating underlying diseases, and ensuring adequate oxygen circulation.<br><br>" +
                        "<b>Recommended Diet:</b> Include iron-rich foods, lean proteins, and antioxidant-rich vegetables like spinach and berries.<br><br>" +
                        "<b>Medicine:</b> Treat underlying conditions; in some cases, iron or vitamin supplements may help.<br><br>" +
                        "<b>More Information:</b> https://www.mountsinai.org/health-library/symptoms/clubbing-of-the-fingers-or-toes#:~:text=Clubbing%20is%20changes%20in%20the,disease%2C%20and%20several%20other%20diseases"
        ));

        infoList.add(new InfoItem(
                "Goiter",
                "<b>Goiter</b> Goiter is an enlargement of the thyroid gland, primarily caused by iodine deficiency. It can result in a visible swelling in the neck and may lead to symptoms like difficulty swallowing, breathing issues, and hormonal imbalances.<br><br>" +
                        "<b>How it Happens:</b> Iodine deficiency or thyroid hormone imbalance.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Consumption of iodine-rich foods like seafood, dairy, and iodized salt.<br><br>" +
                        "<b>Recommended Diet:</b> Include foods rich in iodine such as fish, seaweed, eggs, and dairy products.<br><br>" +
                        "<b>Medicine:</b> Iodine supplements, Levothyroxine for hypothyroidism-related goiter.<br><br>" +
                        "<b>More Information:</b> https://my.clevelandclinic.org/health/diseases/12625-goiter"
        ));

        infoList.add(new InfoItem(
                "Beriberi disease",
                "<b>Beriberi disease</b> Beriberi is caused by a severe deficiency of thiamine (Vitamin B1), leading to nerve damage, muscle wasting, heart problems, and weakness. It is classified into wet beriberi (affecting the heart and circulation) and dry beriberi (affecting the nervous system).<br><br>" +
                        "<b>How it Happens:</b> Thiamine deficiency due to poor diet or alcoholism.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Eating whole grains, legumes, nuts, and lean meats.<br><br>" +
                        "<b>Recommended Diet:</b> Consume foods rich in Vitamin B1 like brown rice, pork, sunflower seeds, and whole grains.<br><br>" +
                        "<b>Medicine:</b> Thiamine supplements in oral or injectable form.<br><br>" +
                        "<b>More Information:</b> https://www.healthline.com/health/beriberi"
        ));

        infoList.add(new InfoItem(
                "Pellagra",
                "<b>Pellagra</b> Pellagra is a disease caused by a deficiency of niacin (Vitamin B3), leading to dermatitis, diarrhea, dementia, and, if untreated, death. It commonly occurs in populations dependent on maize as a staple food without proper niacin enrichment.<br><br>" +
                        "<b>How it Happens:</b> Lack of Vitamin B3 in the diet, malabsorption disorders.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Consumption of niacin-rich foods such as meat, fish, whole grains, and legumes.<br><br>" +
                        "<b>Recommended Diet:</b> Include niacin-rich foods like peanuts, mushrooms, poultry, and fish.<br><br>" +
                        "<b>Medicine:</b> Niacin (Vitamin B3) supplements, Nicotinamide tablets.<br><br>" +
                        "<b>More Information:</b> https://my.clevelandclinic.org/health/diseases/23905-pellagra"
        ));

        infoList.add(new InfoItem(
                "Riboflavin Deficiency",
                "<b>Riboflavin Deficiency</b> Riboflavin (Vitamin B2) deficiency can lead to skin disorders, mouth sores, cracked lips, red eyes, and anemia. It plays a vital role in energy production and cell function.<br><br>" +
                        "<b>How it Happens:</b> Inadequate dietary intake, alcoholism, or malabsorption disorders.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Eating foods rich in riboflavin like dairy, eggs, lean meats, and leafy greens.<br><br>" +
                        "<b>Recommended Diet:</b> Consume milk, almonds, mushrooms, spinach, and whole grains.<br><br>" +
                        "<b>Medicine:</b> Riboflavin (Vitamin B2) supplements.<br><br>" +
                        "<b>More Information:</b> https://www.msdmanuals.com/home/disorders-of-nutrition/vitamins/riboflavin-deficiency"
        ));

        infoList.add(new InfoItem(
                "Night Blindness",
                "<b>Night Blindness</b> Night blindness (nyctalopia) is the inability to see well in low light or darkness, primarily caused by a deficiency of vitamin A, which is crucial for eye health.<br><br>" +
                        "<b>How it Happens:</b> Insufficient vitamin A intake, malnutrition, or liver disorders.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Eating vitamin A-rich foods like carrots, sweet potatoes, and liver.<br><br>" +
                        "<b>Recommended Diet:</b> Increase intake of carrots, spinach, fish, and dairy products.<br><br>" +
                        "<b>Medicine:</b> Vitamin A supplements (Retinol or Beta-Carotene).<br><br>" +
                        "<b>More Information:</b> https://my.clevelandclinic.org/health/symptoms/10118-night-blindness-nyctalopia"
        ));

        infoList.add(new InfoItem(
                "Folate Deficiency",
                "<b>Folate Deficiency</b> Folate (Vitamin B9) deficiency leads to anemia, weakness, birth defects in pregnant women, and poor cell growth.<br><br>" +
                        "<b>How it Happens:</b> Poor diet, pregnancy, alcoholism, or absorption issues.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Eating folate-rich foods like legumes, leafy greens, citrus fruits, and fortified cereals.<br><br>" +
                        "<b>Recommended Diet:</b> Include spinach, lentils, oranges, and nuts in the diet.<br><br>" +
                        "<b>Medicine:</b> Folic acid supplements.<br><br>" +
                        "<b>More Information:</b> https://my.clevelandclinic.org/health/diseases/22198-folate-deficiency"
        ));

        infoList.add(new InfoItem(
                "Essential Fatty Acid Deficiency",
                "<b>Essential Fatty Acid Deficiency</b> A lack of essential fatty acids (Omega-3 and Omega-6) can result in dry skin, hair loss, immune dysfunction, and slow wound healing.<br><br>" +
                        "<b>How it Happens:</b> Low dietary intake of healthy fats, malabsorption issues.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Consuming nuts, seeds, fish, and vegetable oils.<br><br>" +
                        "<b>Recommended Diet:</b> Eat fatty fish, walnuts, flaxseeds, and olive oil.<br><br>" +
                        "<b>Medicine:</b> Omega-3 and Omega-6 supplements (Fish oil, Flaxseed oil capsules).<br><br>" +
                        "<b>More Information:</b> https://www.msdmanuals.com/professional/nutritional-disorders/undernutrition/essential-fatty-acid-deficiency"
        ));

        infoList.add(new InfoItem(
                "Severe Acute Malnutrition (SAM)",
                "<b>Severe Acute Malnutrition (SAM)</b> SAM is a life-threatening condition caused by extreme malnutrition, leading to severe weight loss, weakened immunity, and organ failure.<br><br>" +
                        "<b>How it Happens:</b> Prolonged food deprivation, diseases, or poor feeding practices in children.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Ensuring a nutritious diet and treating infections promptly.<br><br>" +
                        "<b>Recommended Diet:</b> High-calorie foods like milk, eggs, peanut paste (Plumpy'Nut), and fortified cereals.<br><br>" +
                        "<b>Medicine:</b> Therapeutic feeding programs using Ready-to-Use Therapeutic Foods (RUTF), multivitamins.<br><br>" +
                        "<b>More Information:</b> https://medicalguidelines.msf.org/en/viewport/CG/english/severe-acute-malnutrition-16689141.html"
        ));

        infoList.add(new InfoItem(
                        "Moderate Acute Malnutrition (MAM)",
                        "<b>Moderate Acute Malnutrition (MAM)</b> MAM is a moderate form of malnutrition where body weight is significantly lower than normal but not as severe as SAM. It affects immunity, growth, and energy levels.<br><br>" +
                                "<b>How it Happens:</b> Inadequate food intake, infections, and poor diet. <br><br>" +
                "<b>Basic Home Cure Method:</b> Balanced diet with sufficient proteins, carbohydrates, and vitamins.<br><br>" +
                        "<b>Recommended Diet:</b> Include protein-rich foods like eggs, beans, dairy, and whole grains.<br><br>" +
                        "<b>Medicine:</b> Nutritional supplements, fortified foods like F-75 and F-100 formulas.<br><br>" +
                        "<b>More Information:</b> https://www.ncbi.nlm.nih.gov/books/NBK361900/#:~:text=Moderate%20acute%20malnutrition%20(MAM)%2C%20defined%20as%20weight%2Dfor%2Dheight1,115%20millimeters%20and%20%3C125%20millimeters%20(WHO%202012)&text=MAM%20affects%2032.8%20million%20children%20worldwide%2C%2031.8,reside%20in%20LMICs%20(Black%20and%20others%202013)"
        ));

        infoList.add(new InfoItem(
                "Chronic Malnutrition",
                "<b>Chronic Malnutrition</b> Chronic malnutrition is a long-term deficiency in essential nutrients, leading to stunted growth, weakened immunity, and cognitive impairments. It commonly affects children and can have lifelong consequences on physical and mental health.<br><br>" +
                        "<b>How it Happens:</b> Persistent lack of adequate nutrition due to poverty, food insecurity, or poor dietary practices.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Ensuring a balanced diet rich in proteins, vitamins, and minerals from an early age.<br><br>" +
                        "<b>Recommended Diet:</b> Include diverse foods like lean meats, dairy, whole grains, legumes, and fresh fruits.<br><br>" +
                        "<b>Medicine:</b> Nutritional therapy, fortified foods, and multivitamin supplements<br><br>" +
                        "<b>More Information:</b> https://www.betterhealth.vic.gov.au/health/healthyliving/chronic-illness"
        ));

        infoList.add(new InfoItem(
                "Overnutrition (Childhood Obesity)",
                "<b>Overnutrition (Childhood Obesity)</b> Overnutrition occurs when excessive calorie intake leads to obesity, increasing the risk of diabetes, heart disease, and other metabolic disorders.<br><br>" +
                        "<b>How it Happens:</b> Overconsumption of high-calorie, low-nutrient foods combined with a sedentary lifestyle.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Encouraging a healthy diet, regular physical activity, and portion control.<br><br>" +
                        "<b>Recommended Diet:</b> Increase fiber-rich foods like vegetables, whole grains, lean proteins, and reduce processed and sugary foods.<br><br>" +
                        "<b>Medicine:</b> In severe cases, medical intervention may include weight management programs and, rarely, medications like Orlistat (under medical supervision).<br><br>" +
                        "<b>More Information:</b> https://my.clevelandclinic.org/health/diseases/9467-obesity-in-children"
        ));

        infoList.add(new InfoItem(
                "Calcium Deficiency",
                "<b>Calcium Deficiency</b> Calcium deficiency leads to weakened bones, increased risk of fractures, muscle cramps, and osteoporosis in severe cases. Calcium is essential for bone health, nerve function, and muscle contraction.<br><br>" +
                        "<b>How it Happens:</b> Inadequate intake of calcium-rich foods, vitamin D deficiency, or absorption issues.<br><br>" +
                        "<b>Basic Home Cure Method:</b> Consuming dairy products, leafy greens, nuts, and calcium-fortified foods.<br><br>" +
                        "<b>Recommended Diet:</b> Increase intake of milk, cheese, yogurt, almonds, tofu, and leafy greens like kale and spinach.<br><br>" +
                        "<b>Medicine:</b> Calcium supplements such as Calcium Carbonate or Calcium Citrate, often combined with Vitamin D.<br><br>" +
                        "<b>More Information:</b> https://www.medicalnewstoday.com/articles/321865"
        ));

        adapter = new InfoAdapter(infoList);
        recyclerView.setAdapter(adapter);

        // Search functionality
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filter(String text) {
        List<InfoItem> filteredList = new ArrayList<>();
        for (InfoItem item : infoList) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.updateList(filteredList);
    }
}
