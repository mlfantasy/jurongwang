package com.orong.fragment;

import com.orong.OrongApplication;
import com.orong.R;
import com.orong.activity.AboutActivity;
import com.orong.activity.HelpCaptionActivity;
import com.orong.activity.MainActivity;
import com.orong.activity.TelUsActivity;
import com.orong.utils.APPUltil;
import com.orong.view.CustomDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
public class MoreFragment extends Fragment implements OnClickListener {
	private TextView tvTitle;
	private RelativeLayout rlCheckVerson;// 检查更新
	private RelativeLayout rlAboutUs;// 关于我们
	private RelativeLayout rlHelps;// 帮助说明
	private RelativeLayout rlTelUs;// 联系我们
	private Button btExitAPP;// 退出系统
	private CustomDialog dialog;
	private APPUltil appUltil;
	private Handler handler;
//	private C

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_more, container, false);
		tvTitle = (TextView) view.findViewById(R.id.tv_title);
		OrongApplication.setBoldText(tvTitle);
		tvTitle.setText(R.string.more);
		handler= ((MainActivity) getActivity()).handler;
		appUltil = new APPUltil(getActivity(),handler);
		
		rlCheckVerson = (RelativeLayout) view.findViewById(R.id.rl_checkVerson);
		rlCheckVerson.setOnClickListener(this);
		rlAboutUs = (RelativeLayout) view.findViewById(R.id.rl_aboutUs);
		rlAboutUs.setOnClickListener(this);
		rlHelps = (RelativeLayout) view.findViewById(R.id.rl_help);
		rlHelps.setOnClickListener(this);
		rlTelUs = (RelativeLayout) view.findViewById(R.id.rl_telUs);
		rlTelUs.setOnClickListener(this);
		btExitAPP = (Button) view.findViewById(R.id.bt_exitapp);
		btExitAPP.setOnClickListener(this);
		return view;
	}

	public MoreFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.rl_checkVerson:
			appUltil.getNewstVersion("正在检查更新");
		//	dialog=appUltil.getDialog();
		//	Toast.makeText(getActivity(), "检查更新", 0).show();
			break;
		case R.id.rl_aboutUs:
			startActivity(new Intent(getActivity(), AboutActivity.class));
			break;
		case R.id.rl_help:
			startActivity(new Intent(getActivity(), HelpCaptionActivity.class));
			break;
		case R.id.rl_telUs:
			startActivity(new Intent(getActivity(), TelUsActivity.class));
			break;
		case R.id.bt_exitapp:
			((MainActivity)getActivity()).exitAPP();
		default:
			break;
		}

	}
}
