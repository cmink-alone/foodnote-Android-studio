package com.example.trio.foodnote;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trio.foodnote.adapter.CategoryAdapter;
import com.example.trio.foodnote.adapter.LabelAdapter;
import com.example.trio.foodnote.adapter.RecipeAdapter;
import com.example.trio.foodnote.model.Recipe;
import com.example.trio.foodnote.utilities.RecipeData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView rc_label;
    RecyclerView rc_selected;
    RecyclerView rv_category;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Food Note");

        ArrayList<String> labels = new ArrayList<>();
        labels.add("Breakfast");
        labels.add("Appetizers");
        labels.add("Main Dishes");
        labels.add("Side Dishes");

        Map<String, Integer> categories = new HashMap<>();
        categories.put("Foods", R.drawable.label_food);
        categories.put("Ice Creams", R.drawable.label_ice);
        categories.put("Cakes", R.drawable.label_cake);
        categories.put("Fruits", R.drawable.label_fruit);

        LabelAdapter labelAdapter = new LabelAdapter(getActivity(), labels);


        rc_label = (RecyclerView) getView().findViewById(R.id.rc_label);
        rc_label.setAdapter(labelAdapter);
        rc_label.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));


        ArrayList<Recipe> recipes = RecipeData.getData(getActivity());

        RecipeAdapter recipeAdapter = new RecipeAdapter(getActivity(), recipes, R.layout.row_small_recipe);

        rc_selected = (RecyclerView) getView().findViewById(R.id.rc_selected);
        rc_selected.setAdapter(recipeAdapter);
        rc_selected.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));


        CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(), categories);

        rv_category = (RecyclerView) getView().findViewById(R.id.rv_category);
        rv_category.setAdapter(categoryAdapter);
        rv_category.setFocusable(false);
        rv_category.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
