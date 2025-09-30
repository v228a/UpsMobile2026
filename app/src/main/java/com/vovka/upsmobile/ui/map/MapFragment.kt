package com.vovka.upsmobile.ui.map


import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.vovka.upsmobile.R
import com.vovka.upsmobile.entity.PointEntity
import com.vovka.upsmobile.entity.TestData
import com.vovka.upsmobile.ui.menu.MenuFragment
import com.vovka.upsmobile.ui.quiz.QuizFragment
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider


class MapFragment : Fragment() {

    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        MapKitFactory.initialize(requireActivity())
        view.findViewById<ImageView>(R.id.imageView3).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MenuFragment())
                .addToBackStack(null)
                .commit()
        }
        mapView = view.findViewById(R.id.mapview)


        mapView.map.move(
            CameraPosition(
                Point(55.751225, 37.62954),
                /* zoom = */ 17.0f,
                /* azimuth = */ 0f,
                /* tilt = */ 30.0f
            )
        )
        addPlacemarksToMap(TestData.points)


        return view
    }



    private fun addPlacemarksToMap(points: List<PointEntity>) {
        val imageProvider = ImageProvider.fromResource(requireActivity(), R.drawable.ic_map_point)
            points.forEach { point ->
                mapView.map.mapObjects.addPlacemark().apply {
                    geometry = Point(point.latitude, point.longitude)
                    userData = point
                    setIcon(imageProvider)
                }.addTapListener(placemarkTapListener)
            }
        }

    private val placemarkTapListener = MapObjectTapListener { mapObject, point ->
        val pointEntity = mapObject.userData as? PointEntity
        val dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.dialog_layout)
        dialog.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val window = dialog.getWindow()

        if (window != null) {
            val metrics = getResources().getDisplayMetrics()
            val paddingInDp = 29
            val scale = metrics.density
            val paddingInPx = (paddingInDp * scale + 0.5f).toInt() // Конвертируем dp в px

            val width = metrics.widthPixels - (2 * paddingInPx) // ширина экрана минус 2 отступа

            window.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)

            window.findViewById<TextView>(R.id.title).setText(pointEntity!!.title)
            window.findViewById<TextView>(R.id.description).setText(pointEntity!!.description)

            window.findViewById<Button>(R.id.button2).setOnClickListener {
                dialog.hide()
            }
        }

        dialog.show()
        true
        }

    }
